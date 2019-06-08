package org.angrybeard.spiritroomcomm.service;

import org.angrybeard.spiritroomcomm.dto.UserDto;
import org.springframework.web.bind.annotation.*;

/**
 * Created by angry_beary on 2019/6/3.
 */
public interface AdminService {

    @RequestMapping(value = "/getUserInfo1", method = RequestMethod.GET)
    String getUserInfo(@RequestParam("name") String name);

    @RequestMapping(value = "/getUserInfo2", method = RequestMethod.GET)
    UserDto getUserInfo(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/getUserInfo3", method = RequestMethod.POST)
    UserDto getUserInfo(@RequestBody UserDto userDto);
}
