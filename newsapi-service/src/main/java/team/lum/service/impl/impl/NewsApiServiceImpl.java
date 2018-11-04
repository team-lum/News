package team.lum.service.impl.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.lum.model.newsapi.dto.Article;
import team.lum.model.newsapi.response.NewsapiResponse;
import team.lum.model.newsapi.dto.Source;
import team.lum.model.newsapi.response.SourceResponse;
import team.lum.service.impl.NewsApiService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class NewsApiServiceImpl implements NewsApiService {

    private final RestTemplate restTemplate;
    private final String apiKey;

    public static final String API_URL = "https://newsapi.org/v2/";

    @Autowired
    public NewsApiServiceImpl(RestTemplate restTemplate, @Value("${newsapi.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    @Override
    public List<Article> getArticles(String keyWord, Date from, Date to, String sortBy, boolean top) {
        log.info("'getArticles' invoked with params = {}, {}, {}, {}, {}", keyWord, from, to, sortBy, top);

        String url = API_URL + (top ? "top-headlines" : "everything");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        url += "?q=" + keyWord +
                "&from=" + format.format(from) +
                "&to=" + format.format(to) +
                "&sortBy=" + sortBy +
                "&apiKey=" + this.apiKey;

        ResponseEntity<NewsapiResponse> response = restTemplate.getForEntity(url, NewsapiResponse.class);

        return Objects.requireNonNull(response.getBody()).getArticles();
    }

    @Override
    public List<Source> getSources(String language, String country){

        String url = composeUrl(language, country);

        ResponseEntity<SourceResponse> response = restTemplate.getForEntity(url, SourceResponse.class);

        if (!"ok".equals(Objects.requireNonNull(response.getBody()).getStatus()))
            return new ArrayList<>();

        return response.getBody().getSources();
    }

    public String composeUrl(String language, String country){
        String url = API_URL + "sources?";

        if (language != null) url += "language=" + language + "&";
        if (country != null) url += "country=" + country + "&";
        url += "apiKey=" + this.apiKey;

        return url;
    }
}
