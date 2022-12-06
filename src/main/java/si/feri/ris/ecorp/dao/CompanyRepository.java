package si.feri.ris.ecorp.dao;

import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
