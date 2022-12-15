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

    //@Query(value = "SELECT Users.* from Users INNER JOIN Directorate ON Users.id = Directorate.ceo INNER JOIN company ON company.fk_directorate = Directorate.id AND Company.id = ?1", nativeQuery = true)
    @Query(value = "select u from Users u inner join Directorate d on u.id = d.ceo inner join Company c on c.fk_directorate = d.id and c.id = ?1")
    List<Users> getCompanyCEO(int id);

    @Query(value = "select u from Users u inner join Directorate d on u.id = d.hr inner join Company c on c.fk_directorate = d.id and c.id = ?1")
    List<Users> getCompanyHR(int id);
}
