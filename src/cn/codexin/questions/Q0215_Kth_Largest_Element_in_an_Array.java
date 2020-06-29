package cn.codexin.questions;

import java.util.Random;

/**
 * Created by xinGao 2020/6/29
 */

public class Q0215_Kth_Largest_Element_in_an_Array {
    private Random random = new Random();
    public int quickSelect(int[] nums, int lo, int hi, int k){
        int i = randomPartition(nums, lo, hi);
        if(i == k) {
            return nums[i];
        } else {
            return i < k ? quickSelect(nums, i + 1, hi, k) : quickSelect(nums, lo, i - 1, k);
        }

    }
    public int partition(int [] nums, int lo, int hi) {
        int x = nums[hi], i = lo - 1;
        for(int j = lo; j < hi; j++) {
            if(x >= nums[j]) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, hi);
        return i + 1;

    }
    public int randomPartition(int[] nums, int lo, int hi) {
        int i = random.nextInt(hi - lo + 1) + lo;
        swap(nums, i, hi);
        return partition(nums, lo, hi);
    }
    public void swap(int[] nums, int n, int m) {
        int tmp = nums[n];
        nums[n] = nums[m];
        nums[m] = tmp;
    }


    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
}
