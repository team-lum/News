package team.lum.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import team.lum.model.newsapi.Article;
import team.lum.service.NewsapiService;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class NewsapiScheduler {

    private final long fixedRate = 60 * 60 * 1000;
    private final long initialDelay = 1000;

    private final NewsapiService newsapiService;

    @Autowired
    public NewsapiScheduler(NewsapiService newsapiService) {
        this.newsapiService = newsapiService;
    }

    @Scheduled(initialDelay = initialDelay, fixedRate = fixedRate)
    private void getArticle() {
        Date now = new Date();
        Date from = new Date(now.getTime() - 60 * 60 * 1000);
        List<Article> articles = this.newsapiService.getArticles("bitcoin", from, now, "publishedAt", true);

        log.info("articles = {}", articles);
    }

}
