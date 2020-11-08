package com.qiding.jiaguo.controller;

import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.controller.file.FileControllerFeign;
import com.qiding.jiaguo.file.FileDocument;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Api(tags = "图片上传")
@Log4j2
@RestController
public class UserFileController extends BaseController {

    private FileControllerFeign fileService;

    public UserFileController(FileControllerFeign fileService) {
        this.fileService = fileService;
    }

    @ApiOperation("上传图片，返回图片的id")
    @PostMapping("photo/upload")
    public CommonResponse<String> fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        CommonResponse<String> response  = fileService.uploadFile(new FileDocument(file));
        return success(response.getData());
    }

    @ApiOperation("下载图片")
    @GetMapping("photo/down")
    public void fileDown(@RequestParam("fileId") String fileId, HttpServletResponse response) throws IOException {
        FileDocument fileDocument=fileService.downFile(fileId).getData();
        response.setContentType(fileDocument.getContentType());
        response.setHeader("Content-Disposition", "attachment;filename=" +fileDocument.getFileName());
        try(OutputStream outputStream=response.getOutputStream()) {
            outputStream.write(fileDocument.getFileContent());
            response.flushBuffer();
        } catch (IOException e) {
            log.error("文件下载失败{}",fileId,e);
            throw e;
        }
    }
}
