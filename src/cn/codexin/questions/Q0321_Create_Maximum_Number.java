package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/2
 */

public class Q0321_Create_Maximum_Number {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] maxNums = new int[k];
        for(int x = 0; x <= k && x <= n1; x++) {
            int y = k - x;
            if(y > n2) {
                continue;
            }
            int[] subNums1 = getMaxSubNums(nums1, x);
            int[] subNums2 = getMaxSubNums(nums2, y);
            int[] cur = merge(subNums1, subNums2);
            if(compare(cur, 0, maxNums, 0) > 0) {
                System.arraycopy(cur, 0, maxNums, 0, k);
            }
        }
        return maxNums;
    }

    private int compare(int[] nums1, int pos1, int[] nums2, int pos2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        while(pos1 < n1 && pos2 < n2) {
            int diff = nums1[pos1] - nums2[pos2];
            if(diff != 0) {
                return diff;
            }
            pos1++;
            pos2++;
        }
        return (n1 - pos1) - (n2 - pos2);
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] nums = new int[n1 + n2];
        int idx = 0;
        int i = 0, j = 0;
        while(idx < n1 + n2) {
            if(compare(nums1, i, nums2, j) >= 0) {
                nums[idx++] = nums1[i++];
            } else {
                nums[idx++] = nums2[j++];
            }
        }
        return nums;
    }

    public int[] getMaxSubNums(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int top = -1;
        //stack's max pop amount
        int remain = n - k;
        for (int i = 0; i < n; i++) {
            while(top >= 0 && stack[top] < nums[i] && remain > 0) {
                top--;
                remain--;
            }
            if(top < k - 1) {
                stack[++top] = nums[i];
            } else {
                remain--;
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        Q0321_Create_Maximum_Number Q = new Q0321_Create_Maximum_Number();
        Q.maxNumber(new int[]{9,1,2,5,8,3}, new int[]{3,4,6,5}, 5);
    }
}
