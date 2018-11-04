package team.lum.service.impl;

import team.lum.model.newsapi.dto.Article;
import team.lum.model.newsapi.dto.Source;

import java.util.Date;
import java.util.List;

public interface NewsApiService {

    List<Article> getArticles(String keyWord, Date from, Date to, String sortBy, boolean top);

    List<Source> getSources(String language, String country);
}
