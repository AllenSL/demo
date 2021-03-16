package com.example.demo.oss.service.impl;

import com.example.demo.exception.BussinessException;
import com.example.demo.exception.CommonException;
import com.example.demo.oss.cloud.OSSFactory;
import com.example.demo.oss.entity.FileUpLoadResult;
import com.example.demo.oss.entity.FileUpLoadResultList;
import com.example.demo.oss.service.OssService;
import com.example.demo.oss.util.FileTypeJudge;
import com.example.demo.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OssServiceImpl
 * @Description OSS文件上传
 * @Autor ansonglin
 * @Date 2019/5/7 11:58
 * @Version 1.0
 **/
@Slf4j
@Service
public class OssServiceImpl implements OssService {

    @Override
    public FileUpLoadResultList batchUploadFile(MultipartFile[] files, Integer fileType) {
        List<FileUpLoadResult> sussFiles = new ArrayList<>();
        List<FileUpLoadResult> failFiles = new ArrayList<>();
        log.info("开始批量文件上传");
        FileUpLoadResult fileR = null;
        for (MultipartFile file : files) {
            String url;
            try {
                fileR = new FileUpLoadResult();
                url = this.upLoadFileWithUUID(file, fileR, fileType);
                fileR.setFileName(file.getOriginalFilename());
                fileR.setFileUrl(url);
                sussFiles.add(fileR);
            } catch (IOException e) {
                log.error("文件{}上传失败,原因:{}", file.getOriginalFilename(), e.getMessage(), e);
                fileR = new FileUpLoadResult(file.getOriginalFilename(), null, "网络异常");
                failFiles.add(fileR);
            } catch (CommonException e) {
                log.error("文件{}上传失败,原因:{}", file.getOriginalFilename(), e.getMessage(), e);
                fileR = new FileUpLoadResult(file.getOriginalFilename(), null, e.getMessage());
                failFiles.add(fileR);
            } catch (Exception e) {
                log.error("文件{}上传失败,原因:{}", e.getMessage(), e);
                e.printStackTrace();
            }
        }
        log.info("批量文件上传结束");
        return new FileUpLoadResultList(sussFiles, failFiles);
    }

    @Override
    public FileUpLoadResult upLoadFile(MultipartFile file, Integer fileType) {
        log.info("【{}】文件开始上传...", file.getOriginalFilename());
        FileUpLoadResult flr = null;
        try {
            flr = new FileUpLoadResult();
            String url = this.upLoadFileWithUUID(file, flr, fileType);
            flr.setFileName(file.getOriginalFilename());
            flr.setFileUrl(url);
        } catch (IOException e) {
            log.error("文件{}上传失败,原因:{}", file.getOriginalFilename(), e.getMessage(), e);
            throw new CommonException(String.format("文件上传失败，原因:{%s}", e.getMessage()));
        } catch (CommonException e) {
            log.error("文件{}上传失败,原因:{}", file.getOriginalFilename(), e.getMessage(), e);
            flr = new FileUpLoadResult(file.getOriginalFilename(), null, e.getMessage());
        } catch (Exception e) {
            log.error("文件{}上传失败,原因:{}", e.getMessage(), e);
            e.printStackTrace();
        }
        log.info("【{}】文件上传结束", file.getOriginalFilename());
        return flr;
    }


    @Override
    public InputStream getInputStreamBykey(String key) {
        return OSSFactory.build(null).getInputStreamByPath(key);
    }

    @Override
    public List<String> getAllfilesInDefaultBucket() {
        return OSSFactory.build(null).getAllFiles();
    }

    @Override
    public void batchDelOssFiles(List<String> files) {
        OSSFactory.build(null).batchDelFiles(files);
    }

    @Override
    public void saveFileToPath(String url, String filePath, String fileName) {
        log.info("【{}】文件开始下载...", fileName);
        try {
            URL httpUrl = new URL(url);
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
            FileUtils.copyURLToFile(httpUrl, new File(filePath + fileName));
        } catch (MalformedURLException e) {
            log.error("下载文件{}异常，原因：{}", url, e.getMessage(), e);
        } catch (IOException e) {
            log.error("下载文件{}异常，原因：{}", url, e.getMessage(), e);
        }
        log.info("【{}】文件下载完成", fileName);
    }

    /**
     * 以UUID名称上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    public String upLoadFileWithUUID(MultipartFile file, FileUpLoadResult fileR, Integer fileType) throws IOException {
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        FileTypeJudge.isFileType(file, fileType);
        //如果文件类型为视频类型，即fileType = 2，获取视频播放时长
        if (2 == fileType && fileR != null) {
            String length = FileUtils.ReadVideoTime(file);
            fileR.setPlayTime(length);
        }
        return OSSFactory.build(fileType).uploadSuffix(file.getBytes(), suffix);
    }

    /**
     * 以文件原名称上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    public String upLoadFileWithName(MultipartFile file, Integer fileType) throws IOException {
        FileTypeJudge.isFileType(file, fileType);
        return OSSFactory.build(fileType).uploadInrealName(file.getBytes(), file.getOriginalFilename());
    }

    @Override
    public String upLoadFile(MultipartFile file, String name, Integer fileType) throws IOException {
        FileTypeJudge.isFileType(file, fileType);
        name = name + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        return OSSFactory.build(fileType).uploadInrealName(file.getBytes(), name);
    }

    /**
     * 检查当前上传文件是否已经存在,不存在则MD5值入库
     *
     * @param file
     */
    private void checkFileIfExist(MultipartFile file) {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            String fileMd5 = DigestUtils.md5DigestAsHex(inputStream);
            //TODO MD5值查询索引库，不存在则入库
        } catch (IOException e) {
            log.error("文件重复性校验失败，原因：", e.getMessage(), e);
            throw new BussinessException("文件重复性校验失败，原因：" + e.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }
}
