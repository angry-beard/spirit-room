package fun.angrybeard.flowable.idm.service;


import org.flowable.idm.api.Group;
import org.flowable.idm.api.User;

public interface IIDMService {

    void addUser(User user);

    User getUser(User user);

    void addGroup(Group group);

    Group getGroup(Group group);
}
