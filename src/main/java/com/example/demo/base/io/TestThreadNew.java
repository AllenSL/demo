package com.example.demo.base.io;

import java.io.*;

public class TestThreadNew {

    private static long startTime;//开始时间
    private static long endTime;//结束时间

    public static void readFile() {

        File file = new File("D://student.txt");
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
            BufferedReader br = new BufferedReader(isr);
            startTime = System.currentTimeMillis();

            TestThreadNew2 tt;
            String str = "";
            int n = 0;
            try {
                while ((str = br.readLine()) != null) {
                    tt = new TestThreadNew2();
                    n++;
                    tt.str2 = new String(str.getBytes(), "UTF-8");
                    tt.n = n;
                    new Thread(tt).start();
                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("耗时：" + (endTime - startTime));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile();//获取文件daoru
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

}


class TestThreadNew2 implements Runnable {
    public String str2;//当前行内容
    public int n = 0;//当前条数
    public long endTime;//结束时间
    TestThreadNew ttn;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String[] array = str2.split(",");
        System.out.println("当前用的线程：" + Thread.currentThread().getName() + "---第" + n + "条：---" + array[0]);
        ttn = new TestThreadNew();
        endTime = System.currentTimeMillis();
        ttn.setEndTime(endTime);
    }


}