package com.example.demo.test;

import java.util.LinkedList;
import java.util.List;

/**
 * linkedList有序插入
 */
public class LinkedListUtil {

    private static List<Integer> sSorted = new LinkedList<>();

    public static void addElement(int e) {

        if (sSorted.size() == 0) {
            sSorted.add(e);
        } else {
            if (e < sSorted.get(0)) {
                sSorted.add(0, e);
            } else {
                //用于判断是否是最大的标识
                boolean flag = true;
                for (Integer a : sSorted) {
                    if (e < a) {
                        sSorted.add(sSorted.indexOf(a), e);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sSorted.add(sSorted.size(), e);
                }
            }
        }
        System.out.println(sSorted);
    }

    public static void main(String[] args) {
        LinkedListUtil.addElement(99);
        LinkedListUtil.addElement(-2);
        LinkedListUtil.addElement(10);
        LinkedListUtil.addElement(6);
        LinkedListUtil.addElement(300);
        LinkedListUtil.addElement(3);
        LinkedListUtil.addElement(-20);
        LinkedListUtil.addElement(-1);
        LinkedListUtil.addElement(2);
        LinkedListUtil.addElement(3);
        LinkedListUtil.addElement(-300);
        LinkedListUtil.addElement(553);
        LinkedListUtil.addElement(-20);
        LinkedListUtil.addElement(-1);
        LinkedListUtil.addElement(2);
        LinkedListUtil.addElement(3);
    }


}
