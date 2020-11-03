package com.qiding.jiaguo.controller.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserToken {
    private String userId;
    private String userToken;
    private Long expireTime;
}
