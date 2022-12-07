package si.feri.ris.ecorp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Employee extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double _salary;
    public Company _unnamed_Company_;
    public ArrayList<Project> _project = new ArrayList<Project>();

    public double calculateEfficiency() {
        throw new UnsupportedOperationException();
    }
}