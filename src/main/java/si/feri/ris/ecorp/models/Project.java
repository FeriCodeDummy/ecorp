package si.feri.ris.ecorp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String _name;
    private double _budget;
    private String _deadline;
    private String _description;

    // Foreign keys

//    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private ArrayList<Employee> _employees = new ArrayList<Employee>();
//    @ManyToOne(fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JoinColumn(name = "x_id")
//    private Company _company;

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
