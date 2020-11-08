package com.qiding.jiaguo.controller;

import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.constant.ErrorCode;
import com.qiding.jiaguo.controller.request.SendSmsCode;
import com.qiding.jiaguo.controller.request.VerifySmsCode;
import com.qiding.jiaguo.controller.result.VerifyToken;
import com.qiding.jiaguo.service.JMailService;
import com.qiding.jiaguo.service.UserRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "验证码相关")
@RestController
public class EmailVerifyController extends BaseController {

    @Autowired
    private JMailService jMailService;

    @Autowired
    UserRegisterService userRegisterService;

    @ApiOperation("发送验证码")
    @PostMapping("sendSmsCode")
    public CommonResponse sendSmsCode(@RequestBody SendSmsCode sendSmsCode) {
        jMailService.sendActiveSmsCode(sendSmsCode.getUserEmail());
        return success();
    }


    @ApiOperation("验证码验证")
    @PostMapping("verifySmsCode")
    public CommonResponse verifySmsCode(@RequestBody VerifySmsCode verifySmsCode) {
        Boolean verifyResult = jMailService.verifySmsCode(verifySmsCode);
        if (!verifyResult) {
            return CommonResponse.error(ErrorCode.SMS_CODE_ERROR);
        }
        VerifyToken verifyToken = userRegisterService.geneRateVerifyToken(verifySmsCode.getUserEmail());
        return success(verifyToken);
    }

}
