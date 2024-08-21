package com.example.platform.controller;
//import com.example.platform.config.WebMvcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    //@Autowired
    //private WebMvcConfig webMvcConfig;

    // 定义上传文件存储的目录
    @Value("${upload.dir}")
    private String uploadDir;

    @PostMapping("/game/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("请选择要上传的文件");
        }

        try {

            // 获取上传文件的原始文件名
            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());

            // 生成保存文件的路径
            String filePath = uploadDir + File.separator + originalFilename;

            // 保存文件到指定路径
            file.transferTo(new File(filePath));

            return ResponseEntity.ok("文件上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败");
        }
    }
}
