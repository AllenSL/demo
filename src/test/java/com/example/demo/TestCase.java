package com.example.demo;

import com.example.demo.exception.CommonException;
import com.example.demo.exception.ExceptionConstant;

import java.util.LinkedList;

public class TestCase {

//    @Test
    public void testLinkedList(){
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
        lList.add(3,"25");
        lList.push("a");
        System.out.println(lList.peek());
        System.out.println(lList);
        System.out.println(lList.getFirst());
        System.out.println(lList.getLast());
    }

//    @Test
   public void testsortLinkedList(){
        LinkedList<Integer> elemList = new LinkedList<>();
        upSort(3, elemList);
        upSort(2, elemList);
        upSort(1, elemList);
        upSort(8, elemList);
        upSort(6, elemList);
        upSort(5, elemList);
        upSort(4, elemList);
        upSort(3, elemList);
        upSort(2, elemList);
        upSort(1, elemList);
        upSort(8, elemList);
        upSort(6, elemList);
        upSort(5, elemList);
        upSort(4, elemList);
        upSort(3, elemList);
        upSort(2, elemList);
        upSort(1, elemList);
        upSort(8, elemList);
        upSort(6, elemList);
        upSort(5, elemList);
        upSort(4, elemList);
        upSort(3, elemList);
        upSort(2, elemList);
        upSort(1, elemList);
        upSort(8, elemList);
        upSort(6, elemList);
        upSort(5, elemList);
        upSort(4, elemList);
        upSort(3, elemList);
        upSort(2, elemList);
        upSort(1, elemList);
        upSort(8, elemList);
        upSort(1,elemList);
        System.out.println(elemList);
        for (int i = 0;i < elemList.size() ; i ++){
            for (int j = 1;j < elemList.size()-i;j ++){
               if (elemList.get(j+1) > elemList.get(j)){
                   int a = 0;
                   a = elemList.get(j+1);
                   int bbb1 = elemList.get(j+1);
                   int bbb2 = elemList.get(j);
                   bbb1 = bbb2;
                   bbb2 = a;
               }
            }
        }
        System.out.println(elemList);
   }

    /**
     *   降序
     * @param element
     * @param linkedList
     */
//    private void upSort(Integer element, LinkedList<Integer> linkedList) {
//        if (element == null){
//        throw new RuntimeException("插入元素为null");
//        }
//        if (linkedList == null){
//            throw  new RuntimeException("元素集合为null");
//        }
//
//        if (linkedList.size() == 0){
//            linkedList.add(element);
//        }else {
//            if (element > linkedList.getFirst()){
//                linkedList.addFirst(element);
//            }else {
//                boolean flag = true;
//                for (Integer e:
//                     linkedList) {
//                    if (element > e){
//                        int indexOf = linkedList.indexOf(e);
//                        linkedList.add(indexOf,element);
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag){
//                    linkedList.addLast(element);
//                }
//            }
//        }
//    }

    //升序
    public void upSort(Integer element, LinkedList<Integer> linkedList){
        if (element == null){
            throw new RuntimeException("插入元素为null");
        }
        if (linkedList == null){
            throw  new RuntimeException("元素集合为null");
        }

        if (linkedList.size() == 0){
            linkedList.add(element);
        }else {
            if (element < linkedList.getFirst()){
                linkedList.addFirst(element);
            }else {
                boolean flag = true;
                for (Integer e: linkedList) {
                    if (element > e){
                        int indexOf = linkedList.indexOf(e);
                        linkedList.add(indexOf,element);
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    linkedList.addLast(element);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            throw new CommonException(ExceptionConstant.CHECKFAIL_ERROR_CODE,"文件类型不支持");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}


