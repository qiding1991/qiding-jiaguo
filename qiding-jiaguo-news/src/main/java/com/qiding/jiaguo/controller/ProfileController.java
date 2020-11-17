package com.qiding.jiaguo.controller;

import com.google.common.collect.ImmutableMap;
import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.controller.response.ArticleInfo;
import com.qiding.jiaguo.controller.response.AuthorGroup;
import com.qiding.jiaguo.controller.response.AuthorProfile;
import com.qiding.jiaguo.controller.response.VideoInfo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Api(tags = "看看号tab页")
@RestController
@RequestMapping("kankan")
public class ProfileController extends BaseController {

    @GetMapping("author/hot")
    public CommonResponse hotAuthor() {
        List<AuthorProfile> authorList = new ArrayList<>();
        authorList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "生活号", "XXXX生活", 1, 1, 10));
        authorList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "户外", "XXXX打野", 2, 10, 100));
        authorList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "交友", "XXXXxxxx交友", 3, 20, 1000));

        return success(authorList);
    }

    @GetMapping("author/list")
    public CommonResponse authorList() {
        List<AuthorProfile> authorList = new ArrayList<>();
        authorList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "生活号", "XXXX生活", 1, 1, 10));
        authorList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "户外", "XXXX打野", 2, 10, 100));
        authorList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "交友", "XXXXxxxx交友", 3, 20, 1000));
        AuthorGroup authorGroup = new AuthorGroup("游戏", 1, new ArrayList<>(authorList));
        AuthorGroup authorGroup2 = new AuthorGroup("户外", 2, new ArrayList<>(authorList));
        AuthorGroup authorGroup3 = new AuthorGroup("打野", 3, new ArrayList<>(authorList));
        return success(Arrays.asList(authorGroup, authorGroup2, authorGroup3));
    }

    @GetMapping("author/list/{groupId}")
    public CommonResponse authorList(@PathVariable(value = "groupId") String groupId) {
        List<AuthorProfile> authorList = new ArrayList<>();
        authorList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "生活号", "XXXX生活", 1, 1, 10));
        authorList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "户外", "XXXX打野", 2, 10, 100));
        authorList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "交友", "XXXXxxxx交友", 3, 20, 1000));

        authorList.add(new AuthorProfile("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg"
                , "打野", "XXXXxxxx交友", 3, 20, 1000));
        return success(authorList);
    }


    @GetMapping("author/article/list")
    public CommonResponse articleList(@RequestParam(value = "authorId") Long authorId,
                                 @RequestParam(value = "offset") Long offset,
                                 @RequestParam(value = "limit") Long limit) {

        List<ArticleInfo> infoList = new ArrayList<>();
        infoList.add(new ArticleInfo(1,"吃喝", "http://www.baiducom/", "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg", Instant.now().toEpochMilli(), 1010));
        infoList.add(new ArticleInfo(2,"玩", "http://www.baidu.com/", "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg", Instant.now().toEpochMilli(), 1010));
        infoList.add(new ArticleInfo(3,"乐", "http://www.baidu.com/", "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg", Instant.now().toEpochMilli(), 1010));
        infoList.add(new ArticleInfo(4,"户外", "http://www.baidu.com/", "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg", Instant.now().toEpochMilli(), 1010));
        infoList.add(new ArticleInfo(5,"野游", "http://www.baidu.com/", "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg", Instant.now().toEpochMilli(), 1010));
        return success(ImmutableMap.of("article", infoList, "hasMore", true));
    }

    @GetMapping("author/video/list")
    public CommonResponse videoList(@RequestParam(value = "authorId") Long authorId,
                                 @RequestParam(value = "offset") Long offset,
                                 @RequestParam(value = "limit") Long limit) {

        List<VideoInfo> infoList = new ArrayList<>();

        infoList.add(new VideoInfo(1L,"大标题","http://www.baiducom/",
                "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg",
                "http://www.baiducom/",Instant.now().toEpochMilli(), 10,100));
        infoList.add(new VideoInfo(2L,"大标题","http://www.baiducom/",
                "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg",
                "http://www.baiducom/",Instant.now().toEpochMilli(), 10,100));
        infoList.add(new VideoInfo(3L,"大标题","http://www.baiducom/",
                "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg",
                "http://www.baiducom/",Instant.now().toEpochMilli(), 10,100));
        infoList.add(new VideoInfo(4L,"大标题","http://www.baiducom/",
                "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg",
                "http://www.baiducom/",Instant.now().toEpochMilli(), 10,100));
        return success(ImmutableMap.of("article", infoList, "hasMore", true));
    }

}
