package team.lum.elastic.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import team.lum.RestApiApplication;
import team.lum.model.newsapi.dto.Article;

@Ignore // todo make it run with docker
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RestApiApplication.class)
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void findByKeywordTest() {
        Page<Article> noSql = this.articleRepository.findByKeyword("NoSql", PageRequest.of(0, 2));

        log.info("nosql={}", noSql);
        log.info("nosql.content={}", noSql.getContent());
    }
}