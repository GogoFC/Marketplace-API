package se.lexicon.marketplaceapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(updatable = false)
    private String email;

    @Column(updatable = false)
    private String username;


    //Below value of 50 gave error.
    @Column(nullable = false, length = 100)
    private String password;

    private String firstName;

    private String lastName;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private Set<Ad> ads = new HashSet<>();


    public User(String username, String email, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String username, String email, String password, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private void advertise (Ad ad){
        ads.add(ad);
    }

    
    
}
