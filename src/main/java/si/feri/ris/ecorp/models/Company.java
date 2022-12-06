package si.feri.ris.ecorp.models;

import java.util.List;

public class Company {
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
