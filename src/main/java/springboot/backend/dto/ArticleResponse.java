package springboot.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.backend.domain.Article;

@Getter
public class ArticleResponse {

    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.content = article.getContent();
        this.title = article.getTitle();
    }
}
