package team.lum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "team.lum.*")
public class NewsApiService {

    public static void main(String[] args) {
        SpringApplication.run(NewsApiService.class, args);
    }
}
