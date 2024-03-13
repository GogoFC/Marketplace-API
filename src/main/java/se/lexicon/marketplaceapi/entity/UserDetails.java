package se.lexicon.marketplaceapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
public class UserDetails {

    //private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

   private String lastName;

  //  private Set<ItemAd> itemsForSale = new HashSet<>();


}
