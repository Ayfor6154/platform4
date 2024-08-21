package com.example.platform.utils;

import java.io.*;
import java.util.Base64;

public class UploadUtil {
    //这里的pathName表示 你要存到哪，图片名叫啥，如D:\\resources\\image\\smile.jpg

    public static void storeImageAtLocal(String base64ImgData,String pathName){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(base64ImgData);
        /*
         * 字节流转文件
         */
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(pathName);
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //本地图片转base64编码数据
    public static String getImageBase64Data(String localPath){
        File file = new File(localPath);    //URL url = new URL(src);
        byte[] data = null;
        try {
            InputStream in = new FileInputStream(file);  //InputStream in = url.openStream();
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);
    }

}