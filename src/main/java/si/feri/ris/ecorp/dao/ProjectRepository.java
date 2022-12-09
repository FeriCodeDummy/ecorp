package si.feri.ris.ecorp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.Projects;

import java.util.*;

public interface ProjectRepository extends CrudRepository<Projects, Long> {
    @Query(
            value= "select * from projects p where p.funds >= ?1 and ?2 <= (select COUNT(*) FROM project_has_employees e where p.id = e.fk_project)",
            nativeQuery = true
    )
    List<Projects> findByFundsAndJobs(double funds, int jobs);

//    @Query("select h from Hisa h, Soba s where s.hisa = h and s.velikost >= ?1")
//    List<Projects> vrniVelikost(double velikost);

}
