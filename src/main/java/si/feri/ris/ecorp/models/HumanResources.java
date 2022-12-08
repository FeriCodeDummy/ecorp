package si.feri.ris.ecorp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HumanResources{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public boolean changeSalary(Project_Has_Employees aEmployee, double aAmount) {
        throw new UnsupportedOperationException();
    }

    public boolean hireEmployee(Project_Has_Employees aEmployee) {
        throw new UnsupportedOperationException();
    }

    public boolean fireEmployee(Project_Has_Employees aEmployee) {
        throw new UnsupportedOperationException();
    }

}
