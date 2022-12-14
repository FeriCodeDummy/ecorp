package si.feri.ris.ecorp.models;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;
}
