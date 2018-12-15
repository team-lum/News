package team.lum.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping
    public ResponseEntity<Page<Article>> getArticlePage(Pageable pageable) {
        return ResponseEntity.ok(articleRepository.findAll(pageable));
    }

}