package cn.codexin.questions;

import java.util.Stack;

/**
 * Created by xinGao 2020/5/12
 */

public class QInterview1626_Calculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        //清除empty char
        s = s.replaceAll(" ", "");
        int len = s.length(), ans = 0;
        char pre = ' ';
        for(int i = 0; i < len; i++){
            int num = 0;
            while(i < len && isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i++) - '0';
            }
            if(pre == '+') stack.push(num);
            else if(pre == '-') stack.push(-num);
            else if(pre == '*') stack.push(stack.pop() * num);
            else if(pre == '/') stack.push(stack.pop() / num);
            else stack.push(num);
            if(i < len) pre = s.charAt(i);
        }
        while(!stack.isEmpty()) ans += stack.pop();
        return ans;
    }
    public boolean isDigit(char c) {
        return c <= '9' && c >= '0';
    }
}
