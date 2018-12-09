package team.lum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EntityScan("team.lum.model.*")
@SpringBootApplication(scanBasePackages = "team.lum.*")
@EnableElasticsearchRepositories("team.lum.elastic.repository")
public class NewsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsApiApplication.class, args);
    }
}

