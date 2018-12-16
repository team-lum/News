package team.lum.model.newsapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import team.lum.model.newsapi.DateDeserializer;
import team.lum.model.newsapi.DateSerializer;

@Data
@Accessors(chain = true)
@Document(indexName = "news", type = "article")
public class Article {

    @Id
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    private Long publishedAt;

    private String url;
    private Source source;
    private String author;
    private String title;
    private String description;
    private String urlToImage;
    private String content;
}
