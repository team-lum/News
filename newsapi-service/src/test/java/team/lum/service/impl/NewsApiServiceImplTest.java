package team.lum.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import team.lum.model.newsapi.dto.Article;
import team.lum.model.newsapi.response.NewsapiResponse;
import team.lum.service.impl.impl.NewsApiServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@Slf4j
public class NewsApiServiceImplTest {

    @Mock
    private RestTemplate restTemplate;
    private String apiKey;

    private NewsApiServiceImpl newsApiServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        apiKey = "bitcoin";
        newsApiServiceImpl = new NewsApiServiceImpl(restTemplate, apiKey);

    }

    @Test
    public void getArticles() {
        Date from = new Date();
        Date to = new Date();

        NewsapiResponse response = new NewsapiResponse().setArticles(new ArrayList<>());
        ResponseEntity<Object> responseEntity = ResponseEntity.ok(response);

        Mockito.when(restTemplate.getForEntity(anyString(), any()))
                .thenReturn(responseEntity);

        List<Article> actual = newsApiServiceImpl.getArticles("a", from, to, "a", true);
        List<Article> expected = new ArrayList<>();

        String expectedUrl = "https://newsapi.org/v2/top-headlines";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        expectedUrl += "?q=" + "a" +
                "&from=" + format.format(from) +
                "&to=" + format.format(to) +
                "&sortBy=" + "a" +
                "&apiKey=" + this.apiKey;

        Mockito.verify(restTemplate, Mockito.times(1))
                .getForEntity(expectedUrl, NewsapiResponse.class);

        Assert.assertThat(actual, Matchers.equalTo(expected));
    }


    @Test
    public void testComposeUrl(){

        String language = null;
        String country = "us";

        String expectedUrlWithCountry = NewsApiServiceImpl.API_URL +"sources?"+ "country=" + country + "&" +  "apiKey=" + this.apiKey;
        String actual = newsApiServiceImpl.composeUrl(language, country);

        Assert.assertThat(expectedUrlWithCountry, Matchers.equalTo(actual));
    }
}