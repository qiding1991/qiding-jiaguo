package com.qiding.jiaguo.controller.request;

import com.qiding.jiaguo.util.Md5Util;
import com.qiding.jiaguo.entity.UserInfo;
import lombok.Data;

@Data
public class UserBasicInfo {
    private String userName;
    private String password;

    public UserInfo userInfo(String userEmail) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setUserEmail(userEmail);
        userInfo.setPassword(Md5Util.md5Hex(password));
        return userInfo;
    }
}
