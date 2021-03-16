package com.example.demo.oss.util;

import com.example.demo.oss.entity.FileInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FFMpegUtils
 * @Description FFMpeg客户端工具类
 * @Autor ansonglin
 * @Date 2019/5/30 19:41
 * @Version 1.0
 **/
@Slf4j
public class FFMpegUtils {

    /**
     * ffmpeg客户端路径
     */
    static final String FFMPEG_PATH = "D:\\person\\commonTools\\ffmpeg\\bin\\ffmpeg.exe";
    /**
     * ffprobe客户端路径
     */
    static final String FFPROBE_PATH = "D:\\person\\commonTools\\ffmpeg\\bin\\ffprobe.exe";
    /**
     * 获取文件类型的属性
     */
    static String FORMAT_NAME = "format_name";

    /**
     * 获取视频/音频文件信息
     *
     * @param originFileUri 文件绝对路径
     * @return
     */
    public static FileInfo getFileInfo(String originFileUri) {
        try {
            List<String> cmd = new ArrayList<String>();
            cmd.add(FFPROBE_PATH);
            //查询文件信息
            cmd.add("-show_format");
            cmd.add(originFileUri);
            List<String> strs = exec(cmd);
            FileInfo fileInfo = getFileInfo(strs);
            //文件信息获取完成，删除临时文件
            File file = new File(originFileUri);
            file.delete();
            return fileInfo;
        } catch (Exception e) {
            log.error("获取音频信息错误:", e);
        }
        return null;
    }

    /**
     * @param cmd 命令行
     * @return 命令行执行结束返回结果，按行读取返回结果一行一条元素
     * <p>返回结果可能会是多种文件类型如mp4 :format_name=mov,mp4,m4a,3gp,3g2,mj2</p>
     */
    static public List<String> exec(List<String> cmd) {
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(cmd);
            builder.redirectErrorStream(true);
            Process proc = builder.start();
            BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            List<String> strs = new ArrayList<String>();
            String line;
            while ((line = stdout.readLine()) != null) {
                strs.add(line);
            }
            proc.waitFor();
            stdout.close();
            return strs;
        } catch (Exception e) {
            log.error("FFMpeg客户端命令行执行失败，原因：{}", e.getMessage(), e);
        }
        return null;
    }

    private static FileInfo getFileInfo(List<String> strs) {
        if (null == strs || strs.size() == 0) {
            return null;
        }
        FileInfo ai = new FileInfo();
        for (String str : strs) {
            if (str.contains(FORMAT_NAME)) {
                String bak = str.substring(str.indexOf(FORMAT_NAME) + FORMAT_NAME.length());
                String temp = bak.substring(bak.indexOf("=") + 1);
                if (temp != null) {
                    ai.setFileType(temp.trim());
                }
            }
        }
        return ai;
    }
}










