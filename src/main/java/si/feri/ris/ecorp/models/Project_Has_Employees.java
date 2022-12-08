package si.feri.ris.ecorp.models;

import jakarta.persistence.*;

@Entity
public class Project_Has_Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private double _salary;
//    public Company _unnamed_Company_;
//    public ArrayList<Project> _project = new ArrayList<Project>();

    public double calculateEfficiency() {
        throw new UnsupportedOperationException();
    }

}