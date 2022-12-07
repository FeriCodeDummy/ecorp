package si.feri.ris.ecorp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String headquarters;
    private double networth;
    private CEO ceo;
    public HumanResources humanResources;
    public List<Employee> employees;
    public List<Project> projects;
    public String getStats(){
        return "Company: " + name + ", at: " + headquarters + ". Networth: " + networth;
    }

}
