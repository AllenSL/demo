package com.example.demo.oss.util;

import com.example.demo.config.FileSizeConfig;
import com.example.demo.exception.CommonException;
import com.example.demo.exception.ExceptionConstant;
import com.example.demo.ffmpeg.FileType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName FileTypeJudge
 * @Description 根据文件头判断文件类型
 * @Autor ansonglin
 * @Date 2019/5/6 20:08
 * @Version 1.0
 **/
@Slf4j
@Component
public class FileTypeJudge {

    //图片
    private static final FileType[] pics;
    //视频
    private static final FileType[] videos;
    //音频
    private static final FileType[] audios;

    static {
        pics = new FileType[]{FileType.JPEG, FileType.PNG, FileType.TIFF};

        videos = new FileType[]{FileType.AVI, FileType.MP4,  FileType.FLV};

        audios = new FileType[]{FileType.MP3};
    }

    /**
     * 将文件头转换成16进制字符串
     *
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src) {

        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 得到文件头
     *
     * @return 文件头
     * @throws IOException
     */
    private static String getFileContent(InputStream is) throws IOException {

        byte[] b = new byte[28];
        InputStream inputStream = null;
        try {
            is.read(b, 0, 28);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        return bytesToHexString(b);
    }

    /**
     * 判断文件类型
     *
     * @return 文件类型
     */
    public static FileType getType(InputStream is) throws IOException {

        String fileHead = getFileContent(is);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }
        fileHead = fileHead.toUpperCase();
        log.debug("--------------filehead:{}", fileHead);
        FileType[] fileTypes = FileType.values();

        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }

        return null;
    }

    /**
     * 判断文件类型
     *
     * @return
     */
    public static void isFileType(MultipartFile file, Integer fileType) {
        switch (fileType){
            case 1:
                checkPic(file);
                break;
            case 2:
                checkVideo(file);
                break;
            case 3:
                checkAudio(file);
                break;
        }
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
     * 图片校验
     *
     * @param file
     * @return
     */
    public static void  checkPic(MultipartFile file) {
        FileType value = null;
        try {
            value = FileTypeJudge.getType(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //用于标识此文件是否是图片文件
        int flag = 0;
        // 图片
        for (FileType fileType : pics) {
            if (fileType.equals(value)) {
                flag++;
                if (!checkFileSize(file.getSize(), FileSizeConfig.picSize, "M")) {
                    throw new CommonException(ExceptionConstant.FILESIZE_ERROR_CODE, String.format("上传失败，图片大小超过最大上限：%sMB", FileSizeConfig.picSize));
                }
            }
        }
        if (flag == 0) {
            throw new CommonException(ExceptionConstant.FILETYPE_ERROR_CODE, String.format("上传失败，此文件类型暂不支持", file.getOriginalFilename()));
        }
    }

    /**
     * 视频校验
     *
     * @param file
     * @return
     */
    public static void checkVideo(MultipartFile file) {
        FileType value = null;
        try {
            value = FileTypeJudge.getType(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //用于标识此文件是否是视频文件
        int flag = 0;
        for (FileType fileType : videos) {
            if (fileType.equals(value)) {
                flag++;
                if (!checkFileSize(file.getSize(), FileSizeConfig.vedioSize, "M")) {
                    throw new CommonException(ExceptionConstant.FILESIZE_ERROR_CODE, String.format("上传失败，视频大小超过最大上限：%sMB", FileSizeConfig.vedioSize));
                }
            }
        }
        if (flag == 0) {
            throw new CommonException(ExceptionConstant.FILETYPE_ERROR_CODE, String.format("上传失败，此文件类型暂不支持", file.getOriginalFilename()));
        }



    }

    /**
     * 音频校验
     *
     * @param file
     * @return
     */
    public static void checkAudio(MultipartFile file) {
        FileType value = null;
        try {
            value = FileTypeJudge.getType(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //用于标识此文件是否是音频文件
        int flag = 0;
        for (FileType fileType : audios) {
            if (fileType.equals(value)) {
                flag++;
                if (!checkFileSize(file.getSize(), FileSizeConfig.audioSize, "M")) {
                    throw new CommonException(ExceptionConstant.FILESIZE_ERROR_CODE, String.format("上传失败，音频大小超过最大上限：%sMB", FileSizeConfig.audioSize));
                }
            }
        }
        if (flag == 0) {
            throw new CommonException(ExceptionConstant.FILETYPE_ERROR_CODE, String.format("上传失败，此文件类型暂不支持", file.getOriginalFilename()));
        }

    }


}
   