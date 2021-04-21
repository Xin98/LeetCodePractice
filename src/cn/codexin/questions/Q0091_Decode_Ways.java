package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2021/4/21
 */

public class Q0091_Decode_Ways {
    private int[] memo;
    private String s;
    private int n;
    public int numDecodings(String s) {
        this.s = s;
        this.n = s.length();
        memo = new int[n];
        Arrays.fill(memo, - 1);
        return dfs(0);
    }
    public int dfs(int begin) {
        if(begin >= n) {
            return 0;
        }
        // former compute
        if(memo[begin] != -1) {
            return memo[begin];
        }
        if(s.charAt(begin) == '0') {
            memo[begin] = 0;
            return memo[begin];
        }
        if(begin == n - 1) {
            memo[begin] = 1;
            return memo[begin];
        }
        if(begin == n - 2) {
            if(s.charAt(begin) < '2' || s.charAt(begin) == '2' && s.charAt(begin + 1) <= '6') {
                memo[begin] = dfs(begin + 1) + 1;
            } else{
                memo[begin] = dfs(begin + 1);
            }
            return memo[begin];
        }
        if(s.charAt(begin) < '2' || s.charAt(begin) == '2' && s.charAt(begin + 1) <= '6') {
            memo[begin] = dfs(begin + 1) + dfs(begin + 2);
        } else {
            memo[begin] = dfs(begin + 1);
        }
        return memo[begin];
    }
}
