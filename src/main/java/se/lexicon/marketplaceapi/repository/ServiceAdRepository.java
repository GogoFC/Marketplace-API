package se.lexicon.marketplaceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.marketplaceapi.entity.ServiceAd;

@Repository
public interface ServiceAdRepository extends JpaRepository<ServiceAd, Long> {
}
