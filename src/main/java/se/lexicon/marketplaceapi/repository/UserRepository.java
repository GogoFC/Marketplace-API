package se.lexicon.marketplaceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.marketplaceapi.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}
