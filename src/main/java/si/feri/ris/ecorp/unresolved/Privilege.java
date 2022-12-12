package si.feri.ris.ecorp.unresolved;

import jakarta.persistence.*;

@Entity
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    /*
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

     */
}