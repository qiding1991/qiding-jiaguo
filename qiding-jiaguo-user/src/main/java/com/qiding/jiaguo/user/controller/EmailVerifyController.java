package com.qiding.jiaguo.user.controller;

import com.qiding.jiaguo.common.constant.CommonResponse;
import com.qiding.jiaguo.common.constant.ErrorCode;
import com.qiding.jiaguo.common.controller.BaseController;
import com.qiding.jiaguo.user.controller.request.SendSmsCode;
import com.qiding.jiaguo.user.controller.request.VerifySmsCode;
import com.qiding.jiaguo.user.controller.result.VerifyToken;
import com.qiding.jiaguo.user.service.JMailService;
import com.qiding.jiaguo.user.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailVerifyController extends BaseController {

    @Autowired
    private JMailService jMailService;

    @Autowired
    UserRegisterService userRegisterService;

    @PostMapping("sendSmsCode")
    public CommonResponse sendSmsCode(@RequestBody SendSmsCode sendSmsCode) {
        jMailService.sendActiveSmsCode(sendSmsCode.getUserEmail());
        return success();
    }

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
