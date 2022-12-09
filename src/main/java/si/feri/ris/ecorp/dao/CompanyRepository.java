package si.feri.ris.ecorp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.Company;

import java.util.*;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    @Query(
            value= "select * from company c where (select COUNT(*) FROM company_has_projects p where c.id = p.fk_company) >= ?1 and ?2 <= (select COUNT(*) FROM company_has_users e where c.id = e.fk_company)",
            nativeQuery = true
    )
    List<Company> getCompIf(int proj, int users);
}
