package se.lexicon.marketplaceapi.entity;

import jakarta.persistence.*;
import lombok.*;
import se.lexicon.marketplaceapi.dto.UserDTO;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"password", "advertisements", "id"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(updatable = false, unique = true)
    private String email;
    //Below value of 50 gave error.
    @Column(nullable = false, length = 100)
    private String password;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "user_id")
    private Set<Ad> advertisements = new HashSet<>();


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public void addAdvertisement (Ad ad){
        advertisements.add(ad);
        //ad.setUser(this);
    }

    public void removeAdvertisement (Ad ad){
        advertisements.remove(ad);
        //ad.setUser(this);
    }

    public static User from(UserDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
