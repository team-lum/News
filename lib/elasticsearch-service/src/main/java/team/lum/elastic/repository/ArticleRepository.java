package team.lum.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import team.lum.model.newsapi.dto.Article;

public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

}
