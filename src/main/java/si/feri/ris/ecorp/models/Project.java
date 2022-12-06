package si.feri.ris.ecorp.models;

import java.util.ArrayList;

public class Project {
    private String _name;
    private double _budget;
    private String _deadline;
    private String _description;
    public ArrayList<Employee> _employees = new ArrayList<Employee>();
    public Company _company;

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
