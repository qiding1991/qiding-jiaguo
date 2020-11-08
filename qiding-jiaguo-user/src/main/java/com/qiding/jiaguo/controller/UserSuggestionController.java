package com.qiding.jiaguo.controller;

import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.controller.request.UserSuggestionParam;
import com.qiding.jiaguo.service.SuggestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户反馈")
@Log4j2
@RestController
public class UserSuggestionController extends BaseController {

    private SuggestionService suggestionService;

    public UserSuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @ApiOperation(value = "用户反馈")
    @PostMapping("suggestion/commit")
    public CommonResponse commitSuggestion(@RequestBody UserSuggestionParam userSuggestionParam) {
        suggestionService.saveSuggestion(userSuggestionParam.userSuggestion());
        return success();
    }
}
