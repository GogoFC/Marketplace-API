package se.lexicon.marketplaceapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Column(updatable = false)
    private String email;

    //Below value of 50 gave error.
    @Column(nullable = false, length = 100)
    private String password;


    //Moving to UserDetails.
    @OneToOne
    //@JoinColumn(name = "user_details_id", referencedColumnName = "id")
    private UserDetails userDetails;



    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    //AllArgsConstructor annotation conflicts with this redundant constructor, after I deleted userDetails.

}
