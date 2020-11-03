package com.qiding.jiaguo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document("user-info")
public class UserInfo {
    @Id
    private String userId;
    private String userName;
    private String userEmail;
    private String password;
    private String userPhoto;
    private Integer status=1;
    private Long createTime = Instant.now().toEpochMilli();
    private Long updateTime = Instant.now().toEpochMilli();
}
