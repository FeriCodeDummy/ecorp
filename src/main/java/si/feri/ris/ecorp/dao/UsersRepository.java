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

    @Query("SELECT u from Users u where u.username = ?1")
    Users findUserByUsername(String username);

    @Query(value="SELECT u from Users u where u.email = ?1", nativeQuery = true)
    Users findUserByEmail(String username);

    /*
    select u.name, u.surname, u.username, u.wage from users u
    left JOIN company_has_users c ON c.fk_user = u.id
    left JOIN project_has_employees phe ON phe.fk_user = u.id
    WHERE 100000 < (select funds from projects p where p.id = phe.fk_project) and c.fk_company = 1;
     */
    @Query(
            value= "Select * from users u right JOIN company_has_users c on c.fk_user = u.id right JOIN project_has_employees p ON p.fk_user = u.id where u.wage >= ?3 and c.fk_company = ?1 and  p.fk_project = ?2",
            nativeQuery = true
    )
    List<Users> findCompProj(Long comp, Long proj, int wage);

    @Query(
            value= "select * from users u right JOIN company_has_users c ON c.fk_user = u.id right JOIN project_has_employees phe ON phe.fk_user = u.id WHERE ?2 < (select funds from projects p where p.id = phe.fk_project) and c.fk_company = ?1 and u.wage <= ?3",
            nativeQuery = true
    )
    List<Users> changeWage(Long comp, double funds, double wageChange);
//
//    @Modifying
//    @Query("update Users u set username = ?2 where id = ?1")
//    void changeUsername(Long id, String ime);

}
