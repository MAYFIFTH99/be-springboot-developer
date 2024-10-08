package springboot.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.backend.domain.Article;
import springboot.backend.dto.AddArticleRequest;
import springboot.backend.dto.ArticleResponse;
import springboot.backend.dto.UpdateArticleRequest;
import springboot.backend.service.BlogService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogAPIController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(
            @RequestBody AddArticleRequest request
    ) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    //글 목록 조회
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.ok().body(articles);
    }

    //글 한 개 조회
    @GetMapping("/api/article/{id}")
    public ResponseEntity<ArticleResponse> findArticleById(@PathVariable Long id) {
        Article article = blogService.findById(id);
        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

    //글 삭제
    @DeleteMapping("/api/article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        blogService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //글 수정
    @PutMapping("/api/article/{id}")
    public ResponseEntity<Article> updateArticle(
            @PathVariable Long id,
            @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = blogService.update(id, request);
        return ResponseEntity.ok().body(updatedArticle);
    }

}
