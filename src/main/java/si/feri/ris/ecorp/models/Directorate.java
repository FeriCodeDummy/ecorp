package si.feri.ris.ecorp.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Directorate{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "directorate_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Users hr;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "directorate_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Users ceo;

    /**
     * @return ArrayList
     */
    public String getEmployeesReports() {
        throw new UnsupportedOperationException();
    }

}