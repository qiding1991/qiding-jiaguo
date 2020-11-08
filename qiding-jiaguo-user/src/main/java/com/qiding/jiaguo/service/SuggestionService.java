package com.qiding.jiaguo.service;

import com.qiding.jiaguo.entity.UserSuggestion;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class SuggestionService {

    private MongoTemplate mongoTemplate;

    public SuggestionService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void saveSuggestion(UserSuggestion suggestion) {
        mongoTemplate.insert(suggestion);
    }
}
