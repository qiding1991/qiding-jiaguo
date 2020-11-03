package com.qiding.jiaguo.service;

import com.qiding.jiaguo.util.GenerateRedisKeyUtil;
import com.qiding.jiaguo.entity.UserInfo;
import com.qiding.jiaguo.controller.result.VerifyToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserRegisterService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    MongoTemplate mongoTemplate;


    public VerifyToken geneRateVerifyToken(String userEmail) {
        VerifyToken verifyToken = VerifyToken.builder()
                .userEmail(userEmail)
                .expireTime(5 * 60 * 1000L)
                .verifyToken(UUID.randomUUID().toString())
                .build();

        String geneRateVerifyTokenKey = GenerateRedisKeyUtil.geneRateVerifyToken(userEmail);

        ResponseEntity responseEntity = restTemplate.postForEntity("http://qiding-jiaguo-cache/cacheKeyWithEx?key={key}&cacheTime={cacheTime}", verifyToken
                , Void.class, geneRateVerifyTokenKey, verifyToken.getExpireTime());

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            //TODO 异常处理
        }
        return verifyToken;
    }

    public UserInfo registerUser(UserInfo userInfo) {
        UserInfo result = mongoTemplate.insert(userInfo);
        return result;
    }


    public UserInfo findUserInfo(String userId) {
        return mongoTemplate.findById(userId, UserInfo.class);
    }

    public UserInfo updateUserInfo(UserInfo userInfo) {
        userInfo.setUpdateTime(Instant.now().toEpochMilli());
        Query query = Query.query(Criteria.where("userId").is(userInfo.getUserId()));
        mongoTemplate.findAndReplace(query, userInfo);
        return userInfo;
    }

    public  UserInfo findByEmail(String userEmail){

        Query query = Query.query(Criteria.where("userEmail").is(userEmail));

        return  mongoTemplate.findOne(query,UserInfo.class);

    }




}
