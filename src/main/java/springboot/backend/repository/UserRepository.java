package springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.backend.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
