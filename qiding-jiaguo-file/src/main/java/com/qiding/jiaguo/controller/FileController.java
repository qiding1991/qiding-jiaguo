package com.qiding.jiaguo.controller;

import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.controller.file.FileControllerFeign;
import com.qiding.jiaguo.file.FileDocument;
import com.qiding.jiaguo.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController extends BaseController implements FileControllerFeign {

    private FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * 上传文件
     *
     * @param fileDocument
     * @return
     */
    @Override
    @PostMapping("file/upload")
    public CommonResponse<String> uploadFile(@RequestBody FileDocument fileDocument) throws IOException {
        String fileId = fileService.storeFile(fileDocument);
        return success(fileId);
    }

    /**
     * 文件下载
     *
     * @param fileName
     * @return
     */
    @Override
    @GetMapping("file/download")
    public CommonResponse<FileDocument> downFile(@RequestParam("fileName") String fileName) throws IOException {
        FileDocument document = fileService.downFile(fileName);
        return success(document);
    }
}
