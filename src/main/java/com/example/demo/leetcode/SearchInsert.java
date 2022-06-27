package com.example.demo.leetcode;

/**
 * @desc 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left = 0,right= length-1,ans = length;
        while ( left <=right){
          int mid = ((length - left) >>1) + left;
          if(nums[mid] >= target){
              ans = mid;
              right = mid-1;
          }else {
              left = mid +1;
          }
        }
    return ans;
    }


    public static void main(String[] args) {
        int a = 6 >> 1;
        System.out.println(a);
    }

}
