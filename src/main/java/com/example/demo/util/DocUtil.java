package com.example.demo.util;

import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * @ClassName DocUtil
 * @Description TODO
 * @Autor ansonglin
 * @Date 2019/7/2 14:38
 * @Version 1.0
 **/
public class DocUtil {

//    /**
//     * 读取doc文件内容
//     *
//     * @param file
//     *            想要读取的文件对象
//     * @return 返回文件内容
//     * @throws IOException
//     */
//    public static String doc2String(FileInputStream fs) throws IOException {
//        StringBuilder result = new StringBuilder();
//        WordExtractor re = new WordExtractor(fs);
//        result.append(re.getText());
//        re.close();
//        return result.toString();
//    }

//    public static String doc2String(File file) throws IOException {
//        return doc2String(new FileInputStream(file));
//    }

    /**
     *
     * @param wordPath
     * @param wordName
     * @param suffix
     * @param htmlPath
     * @return
     * @throws IOException
     */
    public static String Word2007ToHtml(String wordPath, String wordName, String suffix, String htmlPath)
            throws IOException {
        String htmlName = wordName + ".html";
        String imagePath = htmlPath + "image" + File.separator;
        // 判断html文件是否存在
        File htmlFile = new File(htmlPath + htmlName);
        if (htmlFile.exists()) {
            return htmlFile.getAbsolutePath();
        }
        // word文件
        File wordFile = new File(wordPath + File.separator + wordName + suffix);
        // 1) 加载word文档生成 XWPFDocument对象
        InputStream in = new FileInputStream(wordFile);
        XWPFDocument document = new XWPFDocument(in);
        // 2) 解析 XHTML配置 (这里设置IURIResolver来设置图片存放的目录)
        File imgFolder = new File(imagePath);
        XHTMLOptions options = XHTMLOptions.create();
        options.setExtractor(new FileImageExtractor(imgFolder));
        // html中图片的路径 相对路径
        options.URIResolver(new BasicURIResolver("image"));
        options.setIgnoreStylesIfUnused(false);
        options.setFragment(true);
        // 3) 将 XWPFDocument转换成XHTML
        // 生成html文件上级文件夹
        File folder = new File(htmlPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        OutputStream out = new FileOutputStream(htmlFile);
        XHTMLConverter.getInstance().convert(document, out, options);
        return htmlFile.getAbsolutePath();
    }

//    public static void main(String[] args) {
//        File file = new File("C:\\Users\\Administrator\\Desktop\\易词2.0分析文档.doc易词2.0分析文档.htm");
//        try {
//            String s = doc2String(file);
//            System.out.println(s);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
   