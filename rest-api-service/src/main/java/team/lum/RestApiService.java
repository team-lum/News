package team.lum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "team.lum.*")
public class RestApiService {

    public static void main(String[] args) {
        SpringApplication.run(RestApiService.class, args);
    }
}
