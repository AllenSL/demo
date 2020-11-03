package com.example.demo.util;


import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FileUtils
 * @Description 文件操作工具类
 * @Autor ansonglin
 * @Date 2019/5/15 16:12
 * @Version 1.0
 **/
@Slf4j
public class FileUtils extends org.apache.commons.io.FileUtils {


    /**
     * 输入流转File
     * @param ins
     * @param file
     */
    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取视频时长
     * @param source
     * @return
     */
    public static String ReadVideoTime(File source) {
        Encoder encoder = new Encoder();
        String length = "";
        try {
            MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration()/1000;
            int hour = (int) (ls/3600);
            int minute = (int) (ls%3600)/60;
            int second = (int) (ls-hour*3600-minute*60);
            if(hour >= 1){
                length = hour+":"+minute+":"+second;
            }else {
                length = minute+":"+second;
            }
        } catch (Exception e) {
            log.error("读取视频时长失败，原因：{}",e.getMessage(),e);
        }
        return length;
    }

    /**
     * 读取MultipartFile数据格式 视频时长
     * @param file
     * @return
     */
    public static String ReadVideoTime(MultipartFile file){
        log.info("开始读取视频文件时长...");
        String length = null;
        File cacheFile = null;
        try {
            //暂存文件
            cacheFile = new File(file.getOriginalFilename());
            //MultipartFile->file
            inputStreamToFile(file.getInputStream(),cacheFile);
            //获取时长
            length = ReadVideoTime(cacheFile);
            //延时100ms保证流完全关闭，否则缓存文件删除失败
            Thread.sleep(100);
        } catch (IOException e) {
            log.error("读取视频时长失败，原因：{}",e.getMessage(),e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //删除缓存文件
            cacheFile.delete();
        }
        log.info("读取视频文件时长结束");
        return length;
    }

    /**
     * 通过上传的文件名，缓冲到本地
     * @param filePath 临时缓冲到本地的目录
     * @param file
     */
    public static String cacheFile2Local(String filePath,MultipartFile file) {
        File localFile = new File(filePath);

        if(!localFile.exists()){
            localFile.mkdirs();
        }

        String originalFilename = file.getOriginalFilename();
        String path = filePath+"/"+originalFilename;
        log.debug("createLocalFile path = {}", path);
        localFile = new File(path);
        FileOutputStream fos = null;
        InputStream in = null;
        try {
            if(localFile.exists()){
                //如果文件存在删除文件
                boolean delete = localFile.delete();
                if (delete == false){
                    log.error("Delete exist file \"{}\" failed!!!",path,new Exception("Delete exist file \""+path+"\" failed!!!"));
                }
            }
            //创建文件
            if(!localFile.exists()){
                //如果文件不存在，则创建新的文件
                localFile.createNewFile();
                log.debug("Create file successfully,the file is {}",path);
            }
            //创建文件成功后，写入内容到文件里
            fos = new FileOutputStream(localFile);
            in = file.getInputStream();
            byte[] bytes = new byte[1024];

            int len = -1;

            while((len = in.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            fos.flush();
            log.debug("Reading uploaded file and buffering to local successfully!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(in);
        }
        return path;
    }

    /**
     * 判断文件大小
     *
     * @param len
     * @param size
     * @param unit
     * @return
     */
    public static boolean checkFileSize(Long len, int size, String unit) {
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > size) {
            return false;
        }
        return true;
    }

    /**
     * 复制文件
     * @param oldPath  源文件路径
     * @param newPath  目标文件路径
     */
    public static void copyFileToTargetPath(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                File file = new File(newPath);
                if(file.exists()){
                    file.delete();
                }
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ( (byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        }
        catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();

        }
    }

    /**
     * 按行读取txt文件，放入集合返回
     * @param filePath
     * @return
     */
    public static List<String> readText(String filePath){
             List<String> result = new ArrayList<>();
             BufferedReader reader = null;
        if (filePath == null) {
            return result;
        }
        try {
             reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
            String temp = null;
            while((temp = reader.readLine())!=null){
                result.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(reader);
        }
        return result;
    }

}
   