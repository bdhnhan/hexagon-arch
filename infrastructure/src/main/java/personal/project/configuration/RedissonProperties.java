package personal.project.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(value = "app.redis")
public class RedissonProperties {
    private String address;
    private boolean cluster;
}
