package com.qiding.jiaguo.controller;

import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.controller.pojo.UserBaseInfo;
import com.qiding.jiaguo.controller.request.LoginParam;
import com.qiding.jiaguo.controller.request.UserBasicInfo;
import com.qiding.jiaguo.controller.result.UserToken;
import com.qiding.jiaguo.entity.UserInfo;
import com.qiding.jiaguo.service.TokenService;
import com.qiding.jiaguo.service.UserRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.qiding.jiaguo.constant.ErrorCode.PASSWORD_USE_NAME_ERROR;
@Api(tags = "用户注册")
@Log4j2
@RestController
public class UserRegisterController extends BaseController {

    private UserRegisterService registerService;
    private TokenService tokenService;

    public UserRegisterController(UserRegisterService registerService, TokenService tokenService) {
        this.registerService = registerService;
        this.tokenService = tokenService;
    }


    @ApiOperation("注册用户")
    @PostMapping("register")
    public CommonResponse registerUser(
            @RequestHeader("userEmail") String userEmail,
            @RequestHeader("verifyToken") String verifyToken,
            @RequestBody UserBasicInfo userBasicInfo) {
        UserInfo userInfo = userBasicInfo.userInfo(userEmail);
        userInfo = registerService.registerUser(userInfo);
        UserToken userToken = tokenService.geneRateUserToken(userInfo.getUserId());
        return success(userToken);
    }


    @ApiOperation("用户信息更新")
    @PostMapping("update")
    public CommonResponse updateUser(
            @RequestHeader("userId") String userId,
            @RequestHeader("userToken") String userToken,
            @RequestBody UserBaseInfo userBaseInfo) {
        UserInfo userInfo = registerService.findUserInfo(userId);
        userInfo = userBaseInfo.toUserInfo(userInfo);
        registerService.updateUserInfo(userInfo);
        return success();
    }

    @ApiOperation("邮箱密码登录")
    @PostMapping("userLogin")
    public CommonResponse userLogin(@RequestBody LoginParam loginParam) {
        UserInfo userInfo = registerService.findByEmail(loginParam.getUserEmail());
        if (loginParam.userValid(userInfo)) {
            UserToken userToken = tokenService.geneRateUserToken(userInfo.getUserId());
            return success(userToken);
        }
        return CommonResponse.error(PASSWORD_USE_NAME_ERROR);
    }


    @ApiOperation("用户详情")
    @GetMapping("userDetail")
    public CommonResponse userDetail(
            @RequestHeader("userId") String userId,
            @RequestHeader("userToken") String userToken) {
        UserInfo userInfo = registerService.findUserInfo(userId);
        UserBaseInfo userBaseInfo = new UserBaseInfo(userInfo);
        return CommonResponse.success(userBaseInfo);
    }


}
