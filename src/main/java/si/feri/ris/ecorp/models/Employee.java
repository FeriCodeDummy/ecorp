package si.feri.ris.ecorp.models;

import java.util.ArrayList;

public class Employee extends User {
    private double _salary;
    public Company _unnamed_Company_;
    public ArrayList<Project> _project = new ArrayList<Project>();

    public double calculateEfficiency() {
        throw new UnsupportedOperationException();
    }
}