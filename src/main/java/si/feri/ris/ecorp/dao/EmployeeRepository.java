package si.feri.ris.ecorp.dao;

import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
