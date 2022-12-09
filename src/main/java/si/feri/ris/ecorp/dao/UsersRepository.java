package si.feri.ris.ecorp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.Users;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {
    @Query("select u from Users u where u.fk_utype = (select id from UType t where t.name  = 'CEO')")
    List<Users> getCEO();
    @Query("select u from Users u where u.fk_utype = (select id from UType t where t.name  = 'Employee')")
    List<Users> getEmp();
    @Query("select u from Users u where u.fk_utype = (select id from UType t where t.name  = 'ADMIN')")
    List<Users> getAdmin();
    @Query("select u from Users u where u.fk_utype = (select id from UType t where t.name  = 'HR')")
    List<Users> getHR();
    @Query("select u from Users u where u.fk_utype = (select id from UType t where t.name  = 'StockHolder')")
    List<Users> getSH();

    @Query(
            value= "Select username, wage as \"Salary\" from Users JOIN Company on company.id = 1 JOIN Projects ON projects.id = 1 where users.wage > 1",
            nativeQuery = true
    )
    List<Users> findCompProj(Long comp, Long proj, int wage);
//
//    @Modifying
//    @Query("update Users u set username = ?2 where id = ?1")
//    void changeUsername(Long id, String ime);

}
