package si.feri.ris.ecorp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private String _name;
//    private double _budget;
//    private String _deadline;
//    private String _description;


    // Foreign keys

//    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private ArrayList<Project_Has_Employees> _employees = new ArrayList<Project_Has_Employees>();
//    @ManyToOne(fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JoinColumn(name = "x_id")
//    private Company _company;

    public void assignEmployee(Project_Has_Employees employees) {
        throw new UnsupportedOperationException();
    }

    public void removeEmployee(Project_Has_Employees employees) {
        throw new UnsupportedOperationException();
    }

    public int changeFunds(double aAmount) {
        throw new UnsupportedOperationException();
    }
}
