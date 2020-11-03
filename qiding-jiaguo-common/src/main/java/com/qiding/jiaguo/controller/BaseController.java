package com.qiding.jiaguo.controller;

import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.constant.ErrorCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class BaseController {

    /**
     * 未知异常
     * @param throwable
     * @return
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public CommonResponse exception(Throwable throwable) {
        log.error("服务器未知异常", throwable);
        return CommonResponse.error(ErrorCode.UN_KNOW_ERROR);
    }

    /**
     * 成功
     * @param result
     * @param <T>
     * @return
     */
    public <T> CommonResponse success(T result) {
        return CommonResponse.success(result);
    }


    /**
     * 成功
     * @param <T>
     * @return
     */
    public <T> CommonResponse success() {
        return CommonResponse.success();
    }
}
