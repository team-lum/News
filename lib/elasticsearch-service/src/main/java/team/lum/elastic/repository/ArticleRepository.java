package team.lum.elastic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import team.lum.model.newsapi.dto.Article;

public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

    @Query(value = "{\"query_string\" : {\"fields\": [\"publishedAt\", \"author\", \"title\", \"content\"], \"query\" : \"?0\"}}")
    Page<Article> findByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
