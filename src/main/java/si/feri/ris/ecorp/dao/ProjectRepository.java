package si.feri.ris.ecorp.dao;

import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

//    @Query("select h from Hisa h, Soba s where s.hisa = h and s.velikost >= ?1")
//    List<Project> vrniVelikost(double velikost);

}
