package si.feri.ris.ecorp.models;

import si.feri.ris.ecorp.dao.ProjectRepository;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String _name;
    private double _budget;
    private String _deadline;
    private String _description;

    // Repos
    @AutoWired
    private ProjectRepository projectDao;


    // Foreign keys
    @OneToMany(mappedBy = "hisa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ArrayList<Employee> _employees = new ArrayList<Employee>();
    private Company _company;

    public void assignEmployee(Employee aEmployee) {
        throw new UnsupportedOperationException();
    }

    public void removeEmployee(Employee aEmployee) {
        throw new UnsupportedOperationException();
    }

    public int changeFunds(double aAmount) {
        throw new UnsupportedOperationException();
    }
}
