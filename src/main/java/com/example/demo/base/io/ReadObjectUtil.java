package com.example.demo.base.io;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.List;
import java.util.Random;

/**
 * 多线程读取文件内容测试类
 */
public class ReadObjectUtil {

    public static void writeTestData() {
        try {
            File file = new File("D://student.txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuffer stringBuffer = new StringBuffer();
            Random random = new Random();
            for (int i = 0; i < 1000000; i++) {
                stringBuffer.append("<Student>");
                stringBuffer.append("<name>");
                stringBuffer.append("小明" + i);
                stringBuffer.append("</name>");
                stringBuffer.append("</age>");
                stringBuffer.append(random.nextInt(100));
                stringBuffer.append("<age>");
                stringBuffer.append("</Student>");
                stringBuffer.append("\r\n");
            }
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 多线程读取
     *
     * @param filePath
     * @return
     */
    public static String readInLine(String filePath) {
        try {
            List utf8 = FileUtils.readLines(new File("D://student.txt"), "UTF8");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        List utf8 = FileUtils.readLines(new File("D://student.txt"), "UTF8");
        ReadObjectUtil.writeTestData();

    }
}
