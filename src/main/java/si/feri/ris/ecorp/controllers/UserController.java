package si.feri.ris.ecorp.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import si.feri.ris.ecorp.dao.UTypeRepository;
import si.feri.ris.ecorp.dao.UsersRepository;
import si.feri.ris.ecorp.models.Users;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private UsersRepository usersDao;

	@Autowired
	private UTypeRepository typeDao;





	@GetMapping
	public Iterable<Users> getAllUsers(){
		return usersDao.findAll();
	}

	@PostMapping("/register")
	public Long register(@RequestBody Users user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		usersDao.save(user);
		return usersDao.findUserByUsername(user.getUsername()).getId();

	}


	@PostMapping("/login")
	public boolean login(@RequestBody String body){
		JSONObject json = new JSONObject(body);
		String username = json.getString("username");
		String password = json.getString("password");
		Optional<Users> users = getByUsername(username);
		if (users.isEmpty()){
			Users user= usersDao.findUserByEmail(username);
			if(Optional.ofNullable(user).isEmpty()){
				return false;
			}
			String passwd = user.getPassword();
			return new BCryptPasswordEncoder().matches(password, passwd);

		}

		String passwd = users.get().getPassword();
		return new BCryptPasswordEncoder().matches(password, passwd);
	}

	@PostMapping("/hashPassword")
	public String bruteHash(@RequestBody String body){
		JSONObject json = new JSONObject(body);
		String username = json.getString("username");

		Optional<Users> users = getByUsername(username);
		if (users.isEmpty()){
			System.out.println("Didn't find user with username " + username);
			return "Didn't find user with username";
		}
		Users user = users.get();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode(user.getPassword());
		user.setPassword(password);
		usersDao.save(user);
		return "Password hashed successfully";

	}

	@PostMapping("/changePassword")
	public String changePassword(@RequestBody String body){
		JSONObject json = new JSONObject(body);
		String password = json.getString("password");
		String changePass = json.getString("newPassword");
		String username = json.getString("username");
		Optional<Users> users = getByUsername(username);
		if (users.isEmpty()){
			Users user= usersDao.findUserByEmail(username);
			if(Optional.ofNullable(user).isEmpty()){
				return "User doesn't exist";
			}
			String passwd = user.getPassword();
			if(new BCryptPasswordEncoder().matches(password, passwd)){
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				String p = encoder.encode(changePass);
				user.setPassword(p);
				usersDao.save(user);
				return "Password updated successfully";
			}else{
				return "Password doesn't match";
			}
		}
		Users user = users.get();
		String passwd = user.getPassword();
		if(new BCryptPasswordEncoder().matches(password, passwd)){
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String p = encoder.encode(changePass);
			user.setPassword(p);
			usersDao.save(user);
			return "Password updated successfully";
		}else{
			return "Password doesn't match";
		}
	}

	@GetMapping("/get/{id}")
	public Optional<Users> getByID(@PathVariable(name= "id") Long id){
		return usersDao.findById(id);
	}

	@PutMapping("/{id}/{ime}")
	public Optional<Users> putUsername(@PathVariable(name = "id") Long id, @PathVariable(name = "ime") String ime){
		return usersDao.findById(id).map(user -> {
			user.setUsername(ime);
			return usersDao.save(user);
		});
	}


	@GetMapping("/3param/{comp}/{proj}/{wage}")
	public Iterable<Users> putUsername(@PathVariable(name = "comp") Long comp, @PathVariable(name = "proj") Long proj, @PathVariable(name = "wage") int wage){
		return usersDao.findCompProj(comp, proj, wage);
	}

	@GetMapping("/raise/{comp}/{funds}/{wage}")
	public Iterable<Users> putUsername(@PathVariable(name = "comp") Long comp, @PathVariable(name = "funds") double proj, @PathVariable(name = "wage") double wage){
		return usersDao.changeWage(comp, proj, wage);
	}

	@GetMapping("/username/{username}")
	public Optional<Users> getByUsername(@PathVariable(name = "username") String username){

		Optional<Users> user = Optional.ofNullable(usersDao.findUserByUsername(username));
		if(user.isEmpty()){
			Optional<Users> user_ = Optional.ofNullable(usersDao.findUserByEmail(username.toLowerCase()));
			if(user_.isEmpty()){
				return Optional.empty();
			}
			return user_;
		}

		return user;
		//return Optional.ofNullable(usersDao.findUserByUsername(username));
	}


	@DeleteMapping("/del/{id}")
	public Optional<Object> deleteUser(@PathVariable(name = "id") Long id){
		return usersDao.findById(id).map(user -> {
			usersDao.delete(user);
			return user;
		});
	}


}
