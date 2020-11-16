package com.qiding.jiaguo.controller;


import com.qiding.jiaguo.content.NewContent;
import com.qiding.jiaguo.content.NewContentTypes;
import com.qiding.jiaguo.news.NewType;
import com.qiding.jiaguo.news.PageNews;
import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.content.type.*;
import com.qiding.jiaguo.controller.response.NewPageDetail;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static com.qiding.jiaguo.news.NewType.AD_NEW;

@Api(tags = "热门,国际信息，地区新闻")
@RestController
public class NewController extends BaseController {

    @GetMapping("new/info")
    public CommonResponse<NewPageDetail> hotNew(@RequestParam(value = "size") Integer size,
                                                @RequestParam(value = "newId",required = false) Long newId,
                                                @RequestParam(value = "offset") Integer offset) {

        NewPageDetail pageDetail = new NewPageDetail();


        List<PageNews> newsList = new ArrayList<>();
        List<PageNews> recommendNew = new ArrayList<>();
        //推荐
        PageNews pageNews = PageNews.builder()
//                .url("http://www.baidu.com")
                .newId(1L)
//                .contentType(NewContentTypes.TEXT_AND_LINK.getCode())
                .content(new TextAndLink("头条的-发大水了1"))
                .build();
        recommendNew.add(pageNews);
        PageNews pageNews2 = PageNews.builder()
//                .url("http://www.baidu.com")
                .newId(2L)
//                .contentType(NewContentTypes.TEXT_AND_LINK.getCode())
                .content(new TextAndLink("头条的-发大水了2"))
                .build();
        recommendNew.add(pageNews2);
        PageNews pageNews3 = PageNews.builder()
//                .url("http://www.baidu.com")
                .newId(3L)
//                .contentType(NewContentTypes.TEXT_AND_LINK.getCode())
                .content(new TextAndLink("头条的-发大水了3"))
                .build();
        recommendNew.add(pageNews3);

        //推荐
        GroupRecommend recommend=new GroupRecommend();
        recommend.setGroupName("头条XXXXX新闻");
        recommend.setRecommendIcon("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg");
        recommend.setTextContent(recommendNew);

        PageNews recommendGroup = PageNews.builder()
                .contentType(NewContentTypes.RECOMMEND_GROUP.getCode())
                .content(recommend)
                .build();

        newsList.add(recommendGroup);
        //大图片 布局
        PicAndTitle bigPicAndTitle = PicAndTitle.builder()
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .title("大图片,图片占一行")
                .publishTime(Instant.now().toEpochMilli())
                .subTitle("国际新闻")
                .readCount(10)
                .build();
        newsList.add(PageNews.builder()
                .url("http://www.baidu.com")
                .newId(1L)
                .contentType(NewContentTypes.BIG_PIC_AND_TITLE.getCode())
                .content(bigPicAndTitle)
                .build());

        //正常布局
        bigPicAndTitle = PicAndTitle.builder()
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .title("大图片的")
                .publishTime(Instant.now().toEpochMilli())
                .subTitle("国际新闻")
                .readCount(10)
                .build();
        newsList.add(PageNews.builder()
                .url("http://www.baidu.com")
                .contentType(NewContentTypes.PIC_AND_TITLE.getCode())
                .content(bigPicAndTitle)
                .newId(2L)

                .build());


        //广告布局
        NewContent adWithNoTitle = AdWithNoTitle.builder()
                .subtitle("推广")
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .build();
        newsList.add(PageNews.builder()
                .url("http://www.baidu.com")
                .contentType(NewContentTypes.AD_WITH_NO_TITLE.getCode())
                .content(adWithNoTitle)

                .newId(1L)
                .build());

        //广告
        NewContent adWithTitle = AdWithTitle.builder()
                .subtitle("推广")
                .title("xxxxxxxxxxxxxxx")
                .build();
        newsList.add(PageNews.builder()
                .url("http://www.baidu.com")
                .contentType(NewContentTypes.AD_WITH_TITLE.getCode())
                .content(adWithTitle)

                .newId(2L)
                .build());

        //专栏-文档
        NewContent specialColumnText = SpecialColumnText.builder()
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .author("齐定")
                .subTitle("专栏")
                .publishTime(Instant.now().toEpochMilli())
                .readCount(100)
                .build();

        newsList.add(
                PageNews.builder()
                        .url("http://www.baidu.com")
                        .contentType(NewContentTypes.SPECIAL_COLUMN_TEXT.getCode())
                        .content(specialColumnText)

                        .newId(1L)
                        .build());

        //专栏视频
        NewContent specialColumnVideo = SpecialColumnVideo.builder()
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .author("齐定")
                .subTitle("专栏")
                .title("视频dadadad")
                .commentCounts(1111)
                .publishTime(Instant.now().toEpochMilli())
                .thumbUpCounts(222222)
                .videoUrl("http://dddadadadadad")
                .build();

        newsList.add(
                PageNews.builder()
                        .url("http://www.baidu.com")
                        .contentType(NewContentTypes.SPECIAL_COLUMN_VIDEO.getCode())
                        .content(specialColumnVideo)

                        .newId(2L)
                        .build());

        pageDetail.setHasMore(Boolean.TRUE);
        pageDetail.setNewsList(newsList);
        return success(pageDetail);

    }
}
