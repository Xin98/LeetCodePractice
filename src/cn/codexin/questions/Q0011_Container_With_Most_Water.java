package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/18
 */

public class Q0011_Container_With_Most_Water {
    //双指针
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length-1;
        int lh = height[lo], rh = height[hi], ans = 0;
        for(;lo < hi;){
            if(lh > rh){
                ans = Math.max((hi-lo)*rh, ans);
                hi--;
                rh = height[hi];
            }
            else {
                ans = Math.max((hi-lo)*lh, ans);
                lo++;
                lh = height[lo];
            }
        }
        return ans;
    }
}
