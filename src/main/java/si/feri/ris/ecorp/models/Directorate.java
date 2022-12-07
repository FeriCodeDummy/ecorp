package si.feri.ris.ecorp.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Directorate extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * @return ArrayList
     */
    public String getEmployeesReports() {
        throw new UnsupportedOperationException();
    }
}