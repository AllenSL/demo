package com.example.demo.leetcode;

public class CountStudents {

    public static void main(String[] args) {
//        int[] a = new int[]{1, 1, 1, 0, 0, 1};
//        int[] b = new int[]{1, 0, 0, 0, 1, 1};
//        System.out.println(countStudents(a, b));
        int[] ss = new int[]{1, 2, 3, 4,5, 16,1,2,3,4,56,5,2,67,44};
//        myBubblesort(ss);
//        System.out.println(Arrays.toString(ss));

    }



//    public static void main7(String[] args) {
//        int[] array = {10,5,3,7,6};
//        myBubblesort(array);
//        System.out.println(Arrays.toString(array));
//    }
    public static void getMaxNums(int[] array,int n){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if(array[j] > array[j+1]){
                    int tmp = 0;
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        int index = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
            if(index++ == n){
                break;
            }
        }
    }



    public static int[] test(int[] nums,int n) {
        int[] arr = new int[nums.length];
        int[] res = new int[n];
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] != 0) {
                arr[i] = arr[i] + 1;
            } else {
                arr[i] = 1;
            }
        }
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                res[index++] = i;
            }
            if (index == n) {
                break;
            }
        }
        return res;
    }














    public static int countStudents(int[] students, int[] sandwiches) {
        int students0 = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                students0++;
            }
        }
        int students1 = students.length - students0;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0) {
                students0--;
            } else {
                students1--;
            }
            if (students0 < 0 || students1 < 0) {
                return sandwiches.length - i;
            }
        }
        return 0;
    }
}
