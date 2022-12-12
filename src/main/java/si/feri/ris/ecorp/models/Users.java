package si.feri.ris.ecorp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected String name;
    protected String surname;
    protected String username;
    protected String email;
    protected String password;
    protected double wage;

    // fks
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_utype")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    protected UType fk_utype;

    @ManyToMany(mappedBy = "employees")
    @JsonIgnore
    private List<Projects> projects;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Company> companies;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public UType getFk_utype() {
        return fk_utype;
    }

    public void setFk_utype(UType fk_utype) {
        this.fk_utype = fk_utype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}