package org.angryberad.spiritroomcweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by angry_beary on 2019/6/2.
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CwebApplication.class, args);
    }
}
