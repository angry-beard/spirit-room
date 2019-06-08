package org.angrybeard.spiritroomcomm.dto;


import lombok.*;

/**
 * Created by angry_beary on 2019/6/2.
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;
    private Integer age;

}
