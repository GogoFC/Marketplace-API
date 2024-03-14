package se.lexicon.marketplaceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.marketplaceapi.entity.ItemAd;

@Repository
public interface ItemAdRepository extends JpaRepository<ItemAd, Long> {
}
