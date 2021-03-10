package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2021/3/10
 */

public class Q0224_Basic_Calculator {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int ans = 0;
        int n = s.length();
        int sign = 1;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == ' '){
                continue;
            } else if(s.charAt(i) == '+') {
                sign = ops.peek();
            } else if(s.charAt(i) == '-') {
                sign = - ops.peek();
            } else if(s.charAt(i) == '(') {
                ops.push(sign);
            } else if(s.charAt(i) == ')') {
                ops.pop();
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ans += sign * num;
                i--;
            }
        }
        return ans;
    }
}
