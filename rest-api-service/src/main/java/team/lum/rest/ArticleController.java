package team.lum.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.lum.elastic.repository.ArticleRepository;
import team.lum.model.newsapi.dto.Article;

@Slf4j
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    public final ArticleRepository articleRepository;

    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Retryable(
            maxAttempts = 10,
            value = RuntimeException.class,
            backoff = @Backoff(
                    delay = 1000,
                    multiplier = Math.E,
                    maxDelay = 30000
            )
    )
    @GetMapping
    public ResponseEntity<Page<Article>> getArticlePage(Pageable pageable) {
        log.info("try to get");
        return ResponseEntity.ok(articleRepository.findAll(pageable));
    }

    @Retryable(
            maxAttempts = 10,
            value = RuntimeException.class,
            backoff = @Backoff(
                    delay = 1000,
                    multiplier = Math.E,
                    maxDelay = 30000
            )
    )
    @GetMapping("/search")
    public ResponseEntity<Page<Article>> getByKeyword(@RequestParam("keyword") String keyword, Pageable pageable) {
        return ResponseEntity.ok(articleRepository.findByKeyword(keyword, pageable));
    }
}
