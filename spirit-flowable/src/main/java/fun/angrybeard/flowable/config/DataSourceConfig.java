package fun.angrybeard.flowable.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig{

    private String url;
    private String username;
    private String password;
    @Value("driver-class-name")
    private String driverClassName;

}
