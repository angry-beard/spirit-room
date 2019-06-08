package org.angryberad.spiritroomcweb.web;

import org.angrybeard.spiritroomcomm.dto.UserDto;
import org.angryberad.spiritroomcweb.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by angry_beary on 2019/6/2.
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hello-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.getUserInfo("大明湖畔")).append(System.lineSeparator())
                .append(helloService.getUserInfo("Lucy", 18)).append(System.lineSeparator())
                .append(helloService.getUserInfo(UserDto.builder()
                        .name("Tom")
                        .age(42)
                        .build())).append(System.lineSeparator());
        return sb.toString();
    }
}
