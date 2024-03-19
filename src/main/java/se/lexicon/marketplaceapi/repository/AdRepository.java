package se.lexicon.marketplaceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.marketplaceapi.entity.Ad;

public interface AdRepository extends JpaRepository<Ad,Long> {
}
