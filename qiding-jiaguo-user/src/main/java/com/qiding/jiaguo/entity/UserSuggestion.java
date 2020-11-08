package com.qiding.jiaguo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("user-suggestion")
public class UserSuggestion {
    @Id
    private String id;
    private String content;
    private List<String> images;
}
