package com.example.demo.base.util;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class DownLoadUtil {

    @RequestMapping("/d")
    private String downloadFile(HttpServletResponse response) throws IOException {
        String downloadFilePath = "D://student.txt";
        String fileName = "demo.xml.downloading";//被下载文件的名称
        File file = new File(downloadFilePath);
        long length = file.length();
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开            
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
//            FileInputStream fis = null;
//            BufferedInputStream bis = null;
            try (FileInputStream fis = new FileInputStream(file);
                 BufferedInputStream bis = new BufferedInputStream(fis);) {
                OutputStream outputStream = response.getOutputStream();
                int a = 0;
                int b = 0;
                do {
                    a += b;
                    outputStream.write(buffer, 0, b);
                    b = bis.read(buffer);
                } while (b > 0);
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            }
//            } finally {
//                if (bis != null) {
//                    try {
//                        bis.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                if (fis != null) {
//                    try {
//                        fis.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
////                try {
//////                    Thread.sleep(1000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//                this.test();
//            }
        }
        return "下载失败";
    }

    public void test() {
        File file = new File("C://Users//Administrator//Downloads//demo.xml.downloading");
        String pat1 = "C://Users//Administrator//Downloads//student111.txt";
        File file2 = new File(pat1);
        file.renameTo(file2);
    }
}
