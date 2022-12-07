package si.feri.ris.ecorp.dao;

import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
