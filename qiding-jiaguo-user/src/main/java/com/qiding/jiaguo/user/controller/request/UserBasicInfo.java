package com.qiding.jiaguo.user.controller.request;

import com.qiding.jiaguo.common.util.Md5Util;
import com.qiding.jiaguo.user.entity.UserInfo;
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
