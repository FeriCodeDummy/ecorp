package si.feri.ris.ecorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.ris.ecorp.dao.UTypeRepository;
import si.feri.ris.ecorp.dao.UsersRepository;
import si.feri.ris.ecorp.models.UType;
import si.feri.ris.ecorp.models.Users;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String hello(){
        return "hello";
    }

    @Autowired
    private UTypeRepository utypeDao;

    @Autowired
    private UsersRepository usersDao;

    @GetMapping("/types")
    public Iterable<UType> getAllTypes(){
        return utypeDao.findAll();
    }

    @GetMapping("/three")
    public Iterable<UType> tryGettingThree(){
        return utypeDao.getThree();
    }

    @GetMapping("/ceo")
    public Iterable<Users> tryGettingCEO(){
        return usersDao.getCEO();
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
