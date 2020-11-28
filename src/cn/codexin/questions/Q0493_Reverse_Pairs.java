package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/11/28
 */

public class Q0493_Reverse_Pairs {
    public int reversePairs(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        return reversePairs(nums, 0, nums.length - 1);
    }
    public int reversePairs(int[] nums, int l, int r) {
        if(l == r) {
            return 0;
        }
        int mid = (r - l)/ 2 + l;
        int leftCnt = reversePairs(nums, l, mid);
        int rightCnt = reversePairs(nums, mid + 1, r);
        int[] buff = new int[r - l + 1];
        int idx = 0;
        int idx1 = l, idx2 = mid + 1;
        int ans = 0;
        //统计结果
        while(idx1 <= mid && idx2 <= r) {
            if((long)nums[idx1] > (long)nums[idx2] * 2) {
                ans += mid - idx1 + 1;
                idx2++;
            } else {
                idx1++;
            }
        }
        // 归并排序
        idx1 = l;
        idx2 = mid + 1;
        while(idx1 <= mid && idx2 <= r) {
            if(nums[idx1] <= nums[idx2]) {
                buff[idx++] = nums[idx1++];
            } else {

                buff[idx++] = nums[idx2++];
            }
        }
        while(idx1 <= mid) {
            buff[idx++] = nums[idx1++];
        }
        while(idx2 <= r) {
            buff[idx++] = nums[idx2++];
        }
        System.arraycopy(buff, 0, nums, l, r - l + 1);
        return ans + leftCnt + rightCnt;
    }

    public static void main(String[] args) {
        Q0493_Reverse_Pairs Q = new Q0493_Reverse_Pairs();
        Q.reversePairs(new int[]{2,4,3,5,1});
    }
}
