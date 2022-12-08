package si.feri.ris.ecorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.ris.ecorp.dao.UTypeRepository;
import si.feri.ris.ecorp.dao.UsersRepository;
import si.feri.ris.ecorp.models.Users;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersRepository usersDao;


    @Autowired
    private UTypeRepository typeDao;

    @GetMapping
    public Iterable<Users> getAllUsers(){
        return usersDao.findAll();
    }

    @PostMapping(consumes = "application/json")
    public Optional<Users> addUser(@RequestBody Users user)
    {
        return typeDao.findById(Integer.toUnsignedLong(5)).map(type -> {
                user.setFk_utype(type);
                return usersDao.save(user);
        });
    }
}
