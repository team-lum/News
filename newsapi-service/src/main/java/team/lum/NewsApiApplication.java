package team.lum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "team.lum.*")
public class NewsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsApiApplication.class, args);
    }
}
