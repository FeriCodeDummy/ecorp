package si.feri.ris.ecorp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private String name;
//    private String headquarters;
//    private double networth;
//    private CEO ceo;
//    public HumanResources humanResources;
//    public List<Project_Has_Employees> employees;
//    public List<Project> projects;
}
