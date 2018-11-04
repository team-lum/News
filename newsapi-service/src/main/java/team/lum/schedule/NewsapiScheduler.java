package team.lum.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import team.lum.model.newsapi.dto.Article;
import team.lum.service.impl.impl.NewsApiServiceImpl;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class NewsapiScheduler {

    private final long fixedRate = 60 * 60 * 1000;
    private final long initialDelay = 1000;

    private final NewsApiServiceImpl newsApiServiceImpl;

    @Autowired
    public NewsapiScheduler(NewsApiServiceImpl newsApiServiceImpl) {
        this.newsApiServiceImpl = newsApiServiceImpl;
    }

    @Scheduled(initialDelay = initialDelay, fixedRate = fixedRate)
    private void getArticle() {
        Date now = new Date();
        Date from = new Date(now.getTime() - 60 * 60 * 1000);
        List<Article> articles = this.newsApiServiceImpl.getArticles("bitcoin", from, now, "publishedAt", true);

        log.info("articles = {}", articles);
    }

}
