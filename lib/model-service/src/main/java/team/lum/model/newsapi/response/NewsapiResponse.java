package team.lum.model.newsapi.response;

import lombok.Data;
import lombok.experimental.Accessors;
import team.lum.model.newsapi.dto.Article;

import java.util.List;

@Data
@Accessors(chain = true)
public class NewsapiResponse {

    private String status;
    private int totalResults;
    private List<Article> articles;
}
