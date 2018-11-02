package team.lum.model.newsapi;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class NewsapiResponse {

    private String status;
    private int totalResults;
    private List<Article> articles;
}
