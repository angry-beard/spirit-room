package fun.angrybeard.elasticsearch.dao;

import fun.angrybeard.elasticsearch.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by angry_beary on 2019/11/10.
 */
@Repository
public interface IUserDao extends CrudRepository<User, String> {
}
