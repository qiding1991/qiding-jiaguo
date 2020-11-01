package com.qiding.jiaguo.user.controller.request;

import com.qiding.jiaguo.common.util.Md5Util;
import com.qiding.jiaguo.user.entity.UserInfo;
import lombok.Data;

@Data
public class LoginParam {
    private String password;
    private String userEmail;

    public Boolean userValid(UserInfo userInfo) {
        return userEmail.equals(userInfo.getUserEmail())
                && Md5Util.md5Hex(password).equals(userInfo.getPassword());
    }
}
