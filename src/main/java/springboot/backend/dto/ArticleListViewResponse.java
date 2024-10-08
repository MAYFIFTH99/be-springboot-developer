package springboot.backend.dto;

import lombok.Getter;
import springboot.backend.domain.Article;

@Getter

public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article Article) {
        this.id = Article.getId();
        this.title = Article.getTitle();
        this.content = Article.getContent();
    }
}
