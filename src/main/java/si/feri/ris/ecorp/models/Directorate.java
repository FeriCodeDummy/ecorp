package si.feri.ris.ecorp.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Directorate{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "fk_directorate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    Company company;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ceo")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Users ceo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hr")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Users hr;

    /**
     * @return ArrayList
     */
    public String getEmployeesReports() {
        throw new UnsupportedOperationException();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Users getCeo() {
        return ceo;
    }

    public void setCeo(Users ceo) {
        this.ceo = ceo;
    }

    public Users getHr() {
        return hr;
    }

    public void setHr(Users hr) {
        this.hr = hr;
    }
}