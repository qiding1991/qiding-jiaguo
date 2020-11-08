package com.qiding.jiaguo.controller.file;

import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.file.FileDocument;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@FeignClient(value = "qiding-jiaguo-file")
public interface FileControllerFeign {

    /**
     * 上传文件
     * @param fileDocument
     * @return
     */
    @PostMapping("file/upload")
    CommonResponse<String> uploadFile(@RequestBody FileDocument fileDocument) throws IOException;

    /**
     * 文件下载
     * @param fileName
     * @return
     */
    @GetMapping("file/download")
    CommonResponse<FileDocument> downFile(@RequestParam("fileName") String fileName) throws IOException;

}
