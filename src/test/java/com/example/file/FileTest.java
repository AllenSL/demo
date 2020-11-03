package com.example.file;

import com.example.demo.util.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author ansonglin
 * @className FileTest
 * @description TODO
 * @date 2019/9/3 16:32
 * @cersion 1.0
 **/
public class FileTest {


    @Test
    public void copyPicFile() {
        try {
           List<String> names =  FileUtils.readText("D:\\person\\工作\\考研\\zip-offline\\文件列表\\offline_cet4(核心).txt");
            System.out.println(names.size());
           int num = 0;
            for (int i = 0; i < names.size(); i++) {
                String tstr =  names.get(i);
                String oldUrl = "D:\\person\\工作\\考研\\zip-offline\\offline_1\\word-pic\\"+tstr;
                String desUrl = "D://person//工作//考研//zip-offline//booktype2_bookid7//word-pic//"+tstr;
                File file1 = new File(oldUrl);
                if(!file1.exists()){
                    System.out.println("error :"+tstr);
                }else {
                    num ++;
                    FileUtils.copyFileToTargetPath(oldUrl,desUrl);
                }
            }

            System.out.println(num);
//
//            names.forEach(tstr ->{
//
//            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copyAudioFile() {
        try {
            List<String> names =  FileUtils.readText("C://Users//Administrator//Desktop//offline//offline_3//frequency_audio.txt");

            names.forEach(tstr ->{
                String oldUrl = "C://Users//Administrator//Desktop//offline//offline_1//word-audio//"+tstr;
                String desUrl = "C://Users//Administrator//Desktop//offline//offline_3//word-audio//"+tstr;
                File file1 = new File(oldUrl);
                if(!file1.exists()){
                    System.out.println("error :"+tstr);
                }
                    FileUtils.copyFileToTargetPath(oldUrl,desUrl);

            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}