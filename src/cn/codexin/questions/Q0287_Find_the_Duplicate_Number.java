package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/26
 */

public class Q0287_Find_the_Duplicate_Number {
    //最坏O(n^2)并且改变了原数组 不满足题意
//    public int findDuplicate(int[] nums) {
//        int n = nums.length;
//        for(int i = 0; i < n; i++) {
//            if(nums[i] == i + 1) continue;
//            int tmp = nums[nums[i]-1];
//            if(nums[i] == tmp) return tmp;
//            nums[nums[i]-1] = nums[i];
//            nums[i] = tmp;
//            i--;
//        }
//        return -1;
//    }
    //二分法  O(log(n)*n)
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) cnt++;
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
