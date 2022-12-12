package si.feri.ris.ecorp.dao;

import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
