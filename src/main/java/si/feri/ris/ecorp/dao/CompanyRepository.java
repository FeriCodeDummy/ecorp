package si.feri.ris.ecorp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.Company;
import si.feri.ris.ecorp.models.Users;

import java.util.*;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    @Query(
            value= "select * from company c where (select COUNT(*) FROM company_has_projects p where c.id = p.fk_company) >= ?1 and ?2 <= (select COUNT(*) FROM company_has_users e where c.id = e.fk_company)",
            nativeQuery = true
    )
    List<Company> getCompIf(int proj, int users);

    //@Query(value = "SELECT Users.id, Users.name, Users.surname, Users.username, Users.password, Users.wage, Users.fk_utype from Users INNER JOIN Directorate ON Users.id = Directorate.ceo INNER JOIN company ON company.fk_directorate = Directorate.id AND Company.id = ?1", nativeQuery = true)
    @Query(value = "SELECT Users.* from Users INNER JOIN Directorate ON Users.id = Directorate.ceo INNER JOIN company ON company.fk_directorate = Directorate.id AND Company.id = ?1", nativeQuery = true)
    List<Users> getCompanyCEO(int id);

    @Query(value = "SELECT Users.* from Users INNER JOIN Directorate ON Users.id = Directorate.hr INNER JOIN company ON company.fk_directorate = Directorate.id AND Company.id = ?1", nativeQuery = true)
    List<Users> getCompanyHR(int id);
}
