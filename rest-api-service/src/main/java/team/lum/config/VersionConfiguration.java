package team.lum.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import team.lum.model.Version;

import java.io.IOException;

@Configuration
public class VersionConfiguration {

    private final ObjectMapper objectMapper;

    @Autowired
    public VersionConfiguration(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Bean
    public Version version() throws IOException {
        Resource versionResource = new ClassPathResource("version.json");

        return objectMapper.readValue(
                versionResource.getInputStream(), Version.class);
    }
}
