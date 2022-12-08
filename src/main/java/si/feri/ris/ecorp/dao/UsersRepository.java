package si.feri.ris.ecorp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.Users;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {
    @Query("select u from Users u where u.fk_utype = (select id from UType t where t.name  = 'CEO')")
    List<Users> getCEO();
//
//    @Modifying
//    @Query("update Users u set username = ?2 where id = ?1")
//    void changeUsername(Long id, String ime);

}
