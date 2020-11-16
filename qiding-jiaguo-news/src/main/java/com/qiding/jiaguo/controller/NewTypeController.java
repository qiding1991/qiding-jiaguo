package com.qiding.jiaguo.controller;

import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.controller.response.NewTypeConfig;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "热门,国际信息，地区新闻")
@RestController
public class NewTypeController extends BaseController {

    @GetMapping("new/types")
    public CommonResponse newTypes() {
        List<NewTypeConfig> configList = new ArrayList<>();
        configList.add(new NewTypeConfig("热点", 1));
        configList.add(new NewTypeConfig("国际新闻", 2));
        configList.add(new NewTypeConfig("多伦多信息", 3));
        configList.add(new NewTypeConfig("专栏", 4));
        configList.add(new NewTypeConfig("视频", 5));
        return success(configList);
    }
}
