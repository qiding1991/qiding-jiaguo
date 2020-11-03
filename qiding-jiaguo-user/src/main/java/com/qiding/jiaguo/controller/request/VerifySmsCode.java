package com.qiding.jiaguo.controller.request;

import lombok.Data;

@Data
public class VerifySmsCode {
    private String userEmail;
    private String smsCode;
}
