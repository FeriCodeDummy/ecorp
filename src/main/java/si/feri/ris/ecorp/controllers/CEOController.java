package si.feri.ris.ecorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.feri.ris.ecorp.dao.CEORepository;
import si.feri.ris.ecorp.models.CEO;

@RestController
@RequestMapping("/ceo")
public class CEOController {

    // Repos
    @Autowired
    private CEORepository ceoDao;

    @GetMapping
    public Iterable<CEO> returnCEOs(){
        return ceoDao.returnCEO();
    }
//    @GetMapping("/type/{ceo}")
//    public Iterable<CEO> returnCEO(@PathVariable(name = "ceo") String typeName){
//        return ceoDao.returnCEO(typeName);
//    }
}
