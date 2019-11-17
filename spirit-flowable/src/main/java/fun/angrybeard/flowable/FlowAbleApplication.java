package fun.angrybeard.flowable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "fun.angrybeard.flowable.**" })
@SpringBootApplication
public class FlowAbleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowAbleApplication.class, args);
    }
}