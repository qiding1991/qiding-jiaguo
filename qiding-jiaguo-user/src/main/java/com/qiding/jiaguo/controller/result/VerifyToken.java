package com.qiding.jiaguo.controller.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.value.qual.ArrayLen;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VerifyToken {
    private String verifyToken;
    private Long expireTime;
    private String userEmail;
}
