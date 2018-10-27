package team.lum.config;

import team.lum.model.Version;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VersionConfiguration {

    @Bean
    public Version version() {
        return new Version("1.0.1");
    }
}
