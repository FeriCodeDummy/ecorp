package si.feri.ris.ecorp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CEO extends Directorate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public boolean createProject(String aName, double aFunding, String aDescription) {
        throw new UnsupportedOperationException();
    }

    public boolean deleteProject(Project aProject) {
        throw new UnsupportedOperationException();
    }
}