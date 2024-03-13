package se.lexicon.marketplaceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.marketplaceapi.entity.ItemAd;

public interface ItemAdRepository extends JpaRepository<ItemAd, Long> {
}
