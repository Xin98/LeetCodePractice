package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/4
 */

public class Q0042_Trapping_Rain_Water {
    public int trap(int[] height) {
        int len = height.length;
        if (len == 0) return 0;
        int leftMax = height[0], rightMax = height[len - 1], l = 0, r = len - 1;
        int ans = 0;
        while (l < r) {
            if (leftMax <= rightMax) {
                //如果左边柱子高度的最大值小于右边柱子高度的最大值，那么就从左边往右遍历一个柱子
                //并且实时的更新左边最高的柱子的值
                if (leftMax <= height[++l]) {
                    leftMax = height[l];
                } else {
                    //如果当前的柱子高度值小于两边的最大柱子的高度值，那么能够接住雨水
                    //因为目前左边最高的柱子的高度小于目前右边最高的柱子的高度，所以直接用左边柱子的最高值的减去当前柱子的高度就行。
                    ans += leftMax - height[l];
                }
            } else {
                //同上解释
                if (rightMax <= height[--r]) {
                    rightMax = height[r];
                } else {
                    //同上解释
                    ans += rightMax - height[r];
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Q0042_Trapping_Rain_Water q0042_trapping_rain_water = new Q0042_Trapping_Rain_Water();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        q0042_trapping_rain_water.trap(height);
    }
}
