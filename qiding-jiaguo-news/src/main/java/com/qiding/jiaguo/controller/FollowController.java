package com.qiding.jiaguo.controller;

import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.controller.request.DelFollow;
import com.qiding.jiaguo.controller.response.AuthorProfile;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api("关注")
@RequestMapping("follow")
@RestController
public class FollowController extends BaseController {

    @GetMapping("list")
    public CommonResponse list(@RequestHeader("userId") String userId) {
        List<AuthorProfile> followList = new ArrayList<>();
        followList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "生活号", "XXXX生活", 1, 1, 10));
        followList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "户外", "XXXX打野", 2, 10, 100));
        followList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "交友", "XXXXxxxx交友", 3, 20, 1000));
        return success(followList);
    }

    @PostMapping("del")
    public CommonResponse del(@RequestBody DelFollow delFollow) {
        return success();
    }
}
