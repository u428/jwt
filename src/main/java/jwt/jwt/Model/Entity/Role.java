package jwt.jwt.Model.Entity;

import javax.persistence.*;

@Entity(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String roleName;

    @OneToOne(mappedBy = "roles")
    private UserEntity users;
}
