package si.feri.ris.ecorp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String headquarters;

    // Foreign keys
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_directorate")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Directorate fk_directorate;


    @ManyToMany
    @JoinTable(
            name = "company_has_users",
            joinColumns = @JoinColumn(name = "fk_company"),
            inverseJoinColumns = @JoinColumn(name = "fk_user")
    )
    @JsonIgnore
    Collection<Users> users;

    @ManyToMany
    @JoinTable(
            name = "company_has_projects",
            joinColumns = @JoinColumn(name = "fk_project"),
            inverseJoinColumns = @JoinColumn(name = "fk_company")
    )
    @JsonIgnore
    Collection<Projects> projects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public Directorate getFk_directorate() {
        return fk_directorate;
    }

    public void setFk_directorate(Directorate fk_directorate) {
        this.fk_directorate = fk_directorate;
    }

    public Collection<Users> getUsers() {
        return users;
    }

    public void setUsers(Collection<Users> users) {
        this.users = users;
    }

    public Collection<Projects> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Projects> projects) {
        this.projects = projects;
    }
}
