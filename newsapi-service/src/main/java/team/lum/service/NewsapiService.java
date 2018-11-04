package team.lum.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.lum.model.newsapi.Article;
import team.lum.model.newsapi.NewsapiResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class NewsapiService {

    private final RestTemplate restTemplate;
    private final String apiKey;

    @Autowired
    public NewsapiService(RestTemplate restTemplate, @Value("${newsapi.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public List<Article> getArticles(String keyWord, Date from, Date to, String sortBy, boolean top) {
        String url = "https://newsapi.org/v2/" + (top ? "top-headlines" : "everything");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        url += "?q=" + keyWord +
                "&from=" + format.format(from) +
                "&to=" + format.format(to) +
                "&sortBy=" + sortBy +
                "&apiKey=" + this.apiKey;

        ResponseEntity<NewsapiResponse> response = restTemplate.getForEntity(url, NewsapiResponse.class);

        return response.getBody().getArticles();
    }
}
