package se.lexicon.marketplaceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.marketplaceapi.entity.ServiceAd;

public interface ServiceAdRepository extends JpaRepository<ServiceAd, Long> {
}
