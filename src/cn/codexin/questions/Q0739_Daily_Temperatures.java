package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2020/6/11
 */

public class Q0739_Daily_Temperatures {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> decStack = new LinkedList<>();
        int n = T.length;
        int[] ans = new int[n];
        if(n == 0) return ans;
        for(int i = 1; i < n; i++) {
            while (!decStack.isEmpty() && T[i] > T[decStack.peek()]){
                ans[decStack.peek()] = i - decStack.pop();
            }
            decStack.push(i);
        }
        return ans;
    }
}
