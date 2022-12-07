package si.feri.ris.ecorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.ris.ecorp.dao.ProjectRepository;
import si.feri.ris.ecorp.models.Project;

@RestController
@RequestMapping("/project")
public class ProjectController {

    // Repos
    @Autowired
    private ProjectRepository projectDao;

    @GetMapping
    public Iterable<Project> returnProjects(){
        return projectDao.findAll();
    }

    @PostMapping
    public Project addProject(@RequestBody Project _project){
        return projectDao.save(_project);
    }

}
