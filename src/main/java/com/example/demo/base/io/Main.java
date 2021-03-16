package com.example.demo.base.io;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        BigFileReader.Builder builder = new BigFileReader.Builder("D://student.txt", new IHandle() {

            @Override
            public void handle(String line) {
//				count ++;
                //System.out.println(line);
                //increat();
                if (line.contains("小明19")) {
                    System.out.println(line);
                }
            }
        });
        builder.withTreahdSize(10)
                .withCharset("UTF8")
                .withBufferSize(1024 * 1024);
        BigFileReader bigFileReader = builder.build();
        bigFileReader.start();
    }

}
