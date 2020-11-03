package com.example.demo.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author ansonglin
 * @className ZipPictureUtil
 * @description 图片压缩工具类（参考 https://www.cnblogs.com/jpfss/p/9167240.html）
 * @date 2019/8/27 15:52
 * @cersion 1.0
 **/
public class ZipPictureUtil {


//    public void testThumbnailsByWeigh() {
//        File file = new File(testSaveZipFilePath);
//        File[] files = file.listFiles();
//        for (File sfile : files) {
//            int[] imgWidthHeight = getImgWidthHeight(sfile);
//            int width = imgWidthHeight[0];
//            int height = imgWidthHeight[1];
//            if (width > 400) {
//                System.out.println("source fileName: " + sfile.getName());
//                System.out.println("source width: " + width + "  height: " + height);
//                float perWidth = ((float) 400 / width) * height;
//                File file1 = new File(testSaveZipFilePath + "//" + sfile.getName());
//                //按指定宽高百分比压缩
//                Thumbnails.of(file1).outputQuality(0.1f).size(400, (int) perWidth).toFile(testSaveZipFilePath + "//" + sfile.getName());
//            }
//                else {
//                    System.out.println("noZip fileName: "+sfile.getName());
//                    System.out.println("noZip width: "+width +" height: "+height);
//                    //压缩源文件路径
//                    Thumbnails.of(zipFileSourcePath+"//"+sfile.getName())
//                            //压缩比例
//                            .scale(1f)
//                            //压缩质量
//                            .outputQuality(0.1f)
//                            //压缩后文件保存路径
//                            .toFile(testSaveZipFilePath+"//"+sfile.getName());
//                }
//            }
//    }

    /**
     * 获取图片宽度和高度
     *
     * @return 返回图片的宽度
     */
    public static int[] getImgWidthHeight(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int result[] = {0, 0};
        try {
            // 获得文件输入流
            is = new FileInputStream(file);
            // 从流里将图片写入缓冲图片区
            src = ImageIO.read(is);
            result[0] = src.getWidth(null); // 得到源图片宽
            result[1] = src.getHeight(null);// 得到源图片高
            is.close();  //关闭输入流
        } catch (Exception ef) {
            ef.printStackTrace();
        }

        return result;
    }
}
   