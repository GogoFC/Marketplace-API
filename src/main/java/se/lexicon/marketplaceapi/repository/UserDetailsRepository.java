package se.lexicon.marketplaceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.marketplaceapi.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
