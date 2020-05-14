package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/14
 */

public class Q0238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if(len == 0) return null;
        int[] ans = new int[len];
        int r = 1;
        ans[0] = 1;
        for(int i = 1; i < len; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        for(int i = len-1; i >=0 ; i--){
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
        return ans;
    }
}
