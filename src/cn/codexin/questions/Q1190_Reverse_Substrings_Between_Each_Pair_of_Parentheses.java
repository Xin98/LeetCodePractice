package cn.codexin.questions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xinGao 2021/5/26
 */

public class Q1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    public String reverseParentheses(String s) {
        Deque<String> stack = new ArrayDeque<>();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(sb.toString());
                sb = new StringBuilder();
            } else if(ch == ')') {
                sb = new StringBuilder(stack.pop() + sb.reverse());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
