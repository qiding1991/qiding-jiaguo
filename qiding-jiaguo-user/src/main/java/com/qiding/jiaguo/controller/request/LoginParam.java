package com.qiding.jiaguo.controller.request;

import com.qiding.jiaguo.entity.UserInfo;
import com.qiding.jiaguo.util.Md5Util;
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
