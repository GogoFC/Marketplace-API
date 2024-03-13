package se.lexicon.marketplaceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.marketplaceapi.entity.Favorites;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
}
