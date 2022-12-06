package si.feri.ris.ecorp.dao;

import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
