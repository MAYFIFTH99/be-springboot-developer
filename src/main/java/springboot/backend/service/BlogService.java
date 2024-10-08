package springboot.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.backend.domain.Article;
import springboot.backend.dto.UpdateArticleRequest;
import springboot.backend.repository.BlogRepository;
import springboot.backend.dto.AddArticleRequest;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //글 추가
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    //글 목록 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    //글 한 개 조회
    public Article findById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //글 삭제
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
