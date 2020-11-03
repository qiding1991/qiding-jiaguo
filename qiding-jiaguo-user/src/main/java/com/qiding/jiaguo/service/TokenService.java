package com.qiding.jiaguo.service;

import com.qiding.jiaguo.util.GenerateRedisKeyUtil;
import com.qiding.jiaguo.controller.result.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    RestTemplate restTemplate;

    public UserToken geneRateUserToken(String userId) {
        UserToken userToken = UserToken.builder()
                .userId(userId)
                .expireTime(3 * 60 * 1000L)
                .userToken(UUID.randomUUID().toString())
                .build();

        String geneRateUserTokenKey = GenerateRedisKeyUtil.geneRateUserToken(userId);
        ResponseEntity responseEntity = restTemplate.postForEntity(
                "http://qiding-jiaguo-cache/cacheKeyWithEx?key={key}&cacheTime={cacheTime}"
                , userToken
                , Void.class, geneRateUserTokenKey, userToken.getExpireTime());

        //TODO 异常处理
        return userToken;
    }


}
