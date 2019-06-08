package org.angrybeard.spiritroombweb.web;

import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritroomcomm.dto.UserDto;
import org.angrybeard.spiritroomcomm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by angry_beary on 2019/6/2.
 */
@Slf4j
@RestController
@PropertySource("classpath:demo.properties")
public class AdminController implements AdminService {

    @Value("${time.lafite}")
    private String sipritTime;
    @Autowired
    private DiscoveryClient client;


    @Override
    public String getUserInfo(@RequestParam("name") String name) {
        log.error("hello serviceName:{},serviceId:{}", client.getLocalServiceInstance().getHost(), client.getLocalServiceInstance().getServiceId());
        return "Hello World ! random:" + sipritTime + ";name=" + name;
    }

    @Override
    public UserDto getUserInfo(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        int sleepTime = new Random().nextInt(3000);
        log.error("<<<<<<<<<<<sleepTime:" + sleepTime);
        return UserDto.builder()
                .name(name)
                .age(age)
                .build();
    }

    @Override
    public UserDto getUserInfo(@RequestBody UserDto userDto) {
        return userDto;
    }
}
