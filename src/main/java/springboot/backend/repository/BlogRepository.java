package springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.backend.domain.Article;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
}
