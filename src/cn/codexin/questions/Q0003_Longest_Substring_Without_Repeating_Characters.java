package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/5/2
 */

public class Q0003_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int[] lastIdx = new int[256];
        Arrays.fill(lastIdx, -1);
        int left = 0, ans = 0;
        for(int i = 0; i < len; i++){
            int hash = s.charAt(i);
            if(lastIdx[hash] != -1){
                //统计长度
                ans = Math.max(ans, i - left);
                //重新计算左边界
                left = Math.max(left, lastIdx[hash] + 1);
            }
            //记录当前值的下标
            lastIdx[hash] = i;
        }
        ans = Math.max(ans, len - left);
        return ans;
    }

    public static void main(String[] args) {
        Q0003_Longest_Substring_Without_Repeating_Characters q = new Q0003_Longest_Substring_Without_Repeating_Characters();
        q.lengthOfLongestSubstring("bb");
    }

}
