package team.lum.model.newsapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Accessors(chain = true)
@Document(indexName = "news", type = "source")
public class Source {

    @Id
    private String id;

    private String name;
    private String description;
    private String url;
    private String category;
    private String language;
    private String country;
}
