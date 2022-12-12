package si.feri.ris.ecorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.feri.ris.ecorp.dao.PrivilegeRepository;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
    @Autowired
    private PrivilegeRepository privilegeDao;

}
