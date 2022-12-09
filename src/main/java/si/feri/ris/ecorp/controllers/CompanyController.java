package si.feri.ris.ecorp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.ris.ecorp.dao.CompanyRepository;
import si.feri.ris.ecorp.models.Company;

import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyDao;

    @GetMapping
    public Iterable<Company> giveComp(){
        return companyDao.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Company> findProjectID(@PathVariable(name = "id") Long id){
        return companyDao.findById(id);
    }

    @GetMapping("/getIf/{proj}/{users}")
    public Iterable<Company> getProjectIf(@PathVariable(name = "proj") int proj,@PathVariable(name = "users") int users){
        return companyDao.getCompIf(proj, users);
    }


    @PostMapping
    public Company addComp(@RequestBody Company comp){
        return companyDao.save(comp);
    }

    @PutMapping("/{id}/{name}")
    public Optional<Company> putUsername(@PathVariable(name = "id") Long id, @PathVariable(name = "name") String name){
        return companyDao.findById(id).map(company -> {
            company.setName(name);
            return companyDao.save(company);
        });
    }

    @DeleteMapping("/del/{id}")
    public Optional<Company> deleteUser(@PathVariable(name = "id") Long id){
        return companyDao.findById(id).map(company -> {
            companyDao.delete(company);
            return company;
        });
    }
}
