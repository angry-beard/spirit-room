package fun.angrybeard.elasticsearch.controller;

import fun.angrybeard.elasticsearch.dao.IUserDao;
import fun.angrybeard.elasticsearch.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by angry_beary on 2019/11/10.
 */
@RestController
public class EsController {

    @Autowired
    private IUserDao userDao;


    @PostMapping("add-user")
    public User addUser(@RequestBody User user) {
        return userDao.save(user);
    }
}
