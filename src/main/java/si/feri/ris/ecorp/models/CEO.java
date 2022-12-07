package si.feri.ris.ecorp.models;
import javax.persistence.Entity;

@Entity
public class CEO extends Directorate {

    public boolean createProject(String aName, double aFunding, String aDescription) {
        throw new UnsupportedOperationException();
    }

    public boolean deleteProject(Project aProject) {
        throw new UnsupportedOperationException();
    }
}