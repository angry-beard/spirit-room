package fun.angrybeard.flowable.idm.service.impl;

import fun.angrybeard.flowable.idm.service.IIDMService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.IdentityService;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IDMService implements IIDMService {

    @Autowired
    private IdentityService identityService;

    @Override
    public void addUser(User user) {
        if (identityService.createUserQuery().userId(user.getId()).count() == 0L) {
            UserEntityImpl initUser = (UserEntityImpl) user;
            initUser.setRevision(0);
            identityService.saveUser(initUser);
        } else {
            identityService.saveUser(user);
        }
    }

    @Override
    public User getUser(User user) {
        return identityService.createUserQuery().userId(user.getId()).singleResult();
    }

    @Override
    public void addGroup(Group group) {
        if (identityService.createGroupQuery().groupId(group.getId()).count() == 0L) {
            GroupEntityImpl initGroup = (GroupEntityImpl) group;
            initGroup.setRevision(0);
            identityService.saveGroup(initGroup);
        } else {
            identityService.saveGroup(group);
        }
    }

    @Override
    public Group getGroup(Group group) {
        return identityService.createGroupQuery().groupId(group.getId()).singleResult();
    }
}
