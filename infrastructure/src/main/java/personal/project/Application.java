package personal.project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "personal.project.db.entity")
@EnableJpaRepositories(basePackages = "personal.project.db")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
