package si.feri.ris.ecorp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.ris.ecorp.dao.UTypeRepository;
import si.feri.ris.ecorp.dao.UsersRepository;
import si.feri.ris.ecorp.models.UType;
import si.feri.ris.ecorp.models.Users;

@RestController
@RequestMapping("/utypes")
public class UTypeController {

    @Autowired
    private UTypeRepository utypeDao;

    @Autowired
    private UsersRepository usersDao;

    @GetMapping
    public Iterable<UType> getAllTypes(){
        return utypeDao.findAll();
    }

    @GetMapping("/employee")
    public Iterable<Users> getEmployees(){
        return usersDao.getEmp();
    }

    @GetMapping("/admin")
    public Iterable<Users> getAdmin(){
        return usersDao.getAdmin();
    }

    @GetMapping("/ceo")
    public Iterable<Users> tryGettingCEO(){
        return usersDao.getCEO();
    }

    @GetMapping("/hr")
    public Iterable<Users> getHR(){
        return usersDao.getHR();
    }

    @GetMapping("/sh")
    public Iterable<Users> getSH(){
        return usersDao.getSH();
    }

    @PostMapping(value = "/new/type", consumes = "application/json")
    public UType addUType(@RequestBody UType type){
        return utypeDao.save(type);
    }

    @PostMapping(consumes = "application/json")
    public Users addUser(@RequestBody Users user)
    {
        return usersDao.save(user);
    }
}
