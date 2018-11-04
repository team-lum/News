package team.lum.model.newsapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import team.lum.model.newsapi.dto.Source;

import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SourceResponse {

    private String status;
    private List<Source> sources;
}
