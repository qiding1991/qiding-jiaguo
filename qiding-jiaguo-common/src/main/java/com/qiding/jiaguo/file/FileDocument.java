package com.qiding.jiaguo.file;

import com.qiding.jiaguo.util.Md5Util;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("file-info")
public class FileDocument {
    @Id
    private String fileId;
    private String fileName;
    private String contentType;
    private Long fileSize;
    private String md5;
    private byte[]fileContent;
    private Long createTime = Instant.now().toEpochMilli();

    public FileDocument(MultipartFile file) throws IOException {
        this.fileId= UUID.randomUUID().toString();
        this.contentType = file.getContentType();
        this.fileName = file.getOriginalFilename();
        this.fileSize = file.getSize();
        this.fileContent=file.getBytes();
        this.md5 = Md5Util.md5Hex(this.fileContent);
    }

    public static  boolean isNotNull(FileDocument fileDocument){
        return fileDocument!=null && fileDocument.fileId!=null;
    }
}
