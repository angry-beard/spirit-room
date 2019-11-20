package fun.angrybeard.flowable.idm.service.impl;

import com.alibaba.fastjson.JSONObject;
import fun.angrybeard.flowable.idm.IDMApplication;
import fun.angrybeard.flowable.idm.service.IIDMService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IDMApplication.class})
public class IDMServiceTest {

    @Autowired
    private IIDMService idmService;

    @Test
    public void addUser() {
        User user = new UserEntityImpl();
        user.setId("angry_river");
        user.setDisplayName("愤怒的河水");
        user.setEmail("better_river@163.com");
        user.setFirstName("马");
        user.setLastName("云");
        user.setPassword("123");
        user.setTenantId("00000");

        idmService.addUser(user);
    }

    @Test
    public void getUser() {
        User user = new UserEntityImpl();
        user.setId("angry_beard");
        User result = idmService.getUser(user);
        log.info(JSONObject.toJSONString(result));
    }

    @Test
    public void addGroup() {
        Group group = new GroupEntityImpl();
        group.setId("1");
        group.setName("研发部");
        group.setType("type_test");
        idmService.addGroup(group);
    }

    @Test
    public void getGroup() {
        Group group = new GroupEntityImpl();
        group.setId("1");
        Group result = idmService.getGroup(group);
        log.info(JSONObject.toJSONString(result));
    }
}