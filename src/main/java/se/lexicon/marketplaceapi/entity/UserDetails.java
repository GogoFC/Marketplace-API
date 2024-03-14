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
public class UserDetails {



    /*
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

     */
    @OneToOne(mappedBy = "userDetails")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    public UserDetails(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //  private Set<ItemAd> itemsForSale = new HashSet<>();


    //public void

}
