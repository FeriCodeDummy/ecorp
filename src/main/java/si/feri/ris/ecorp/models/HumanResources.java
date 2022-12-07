package si.feri.ris.ecorp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HumanResources extends Directorate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public boolean changeSalary(Employee aEmployee, double aAmount) {
        throw new UnsupportedOperationException();
    }

    public boolean hireEmployee(Employee aEmployee) {
        throw new UnsupportedOperationException();
    }

    public boolean fireEmployee(Employee aEmployee) {
        throw new UnsupportedOperationException();
    }
}
