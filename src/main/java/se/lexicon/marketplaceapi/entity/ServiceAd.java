package se.lexicon.marketplaceapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ServiceAd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
