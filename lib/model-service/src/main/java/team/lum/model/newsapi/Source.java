package team.lum.model.newsapi;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Source {

    private String id;
    private String name;
}
