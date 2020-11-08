package com.qiding.jiaguo.controller.request;

import com.qiding.jiaguo.entity.UserSuggestion;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class UserSuggestionParam {
    private String content;
    private List<String> images;

    public UserSuggestion userSuggestion() {
        UserSuggestion suggestion = new UserSuggestion();
        BeanUtils.copyProperties(this, suggestion);
        return suggestion;

    }
}
