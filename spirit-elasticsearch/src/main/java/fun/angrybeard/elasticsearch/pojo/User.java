package fun.angrybeard.elasticsearch.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by angry_beary on 2019/11/10.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "quite", type = "user")
public class User {

    private String id;
    private String name;
    private String sex;
    private String age;
}
