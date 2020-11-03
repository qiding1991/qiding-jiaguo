package com.qiding.jiaguo.controller.pojo;

import com.qiding.jiaguo.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.Instant;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserBaseInfo {
    private String userName;
    private String password;
    private String userPhoto;
    private String userEmail;

    public UserInfo toUserInfo(UserInfo userInfo) {
        String[] ignoreFields = Stream.of(UserBaseInfo.class.getDeclaredFields()).filter(
                field -> {
                    try {
                        return field.get(this)==null;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
        ).map(field -> field.getName()).toArray(String[]::new);
        BeanUtils.copyProperties(this, userInfo, ignoreFields);
        userInfo.setUpdateTime(Instant.now().toEpochMilli());
        return userInfo;
    }

    public UserBaseInfo(UserInfo userInfo){
        this.userEmail=userInfo.getUserEmail();
        this.userPhoto=userInfo.getUserPhoto();
        this.userName=userInfo.getUserName();
    }


}
