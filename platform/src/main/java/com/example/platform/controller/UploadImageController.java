package com.example.platform.controller;

import com.example.platform.utils.UploadUtil;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class UploadImageController {
    //这里的 faceImage 就是 a-upload 的 name 属性
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("faceImage") MultipartFile pic) {
        /*
         * 编码为字符串
         */
        String base64Str = "";
        try {
            base64Str = Base64Utils.encodeToString(pic.getBytes());     //将图片转化为base64格式
            //String imgName = pic.pic.getOriginalFilename();             //获取到图片原本的名字
            String imgName = pic.getOriginalFilename();
            UploadUtil.storeImageAtLocal(base64Str, imgName);                      //为了方便在其他地方调用，这里封装成了一个工具类
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
