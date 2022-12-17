package si.feri.ris.ecorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.ris.ecorp.dao.ProjectRepository;
import si.feri.ris.ecorp.models.Projects;

import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/project")
public class ProjectController {

    // Repos
    @Autowired
    private ProjectRepository projectDao;

    @GetMapping
    public Iterable<Projects> returnProjects(){
        return projectDao.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Projects> returnProjects(@PathVariable(name = "id") Long id){
        return projectDao.findById(id);
    }

    @GetMapping("/getIf/{funds}/{jobs}")
    public Iterable<Projects> findBig(@PathVariable(name = "funds") double funds, @PathVariable(name = "jobs") int jobs){
        return projectDao.findByFundsAndJobs(funds, jobs);
    }

    @PostMapping
    public Projects addProject(@RequestBody Projects project){
        return projectDao.save(project);
    }

}
