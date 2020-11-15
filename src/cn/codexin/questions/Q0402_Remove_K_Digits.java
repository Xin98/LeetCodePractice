package cn.codexin.questions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xinGao 2020/11/15
 */

public class Q0402_Remove_K_Digits {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : num.toCharArray()) {
            while(k > 0 && !stack.isEmpty() && stack.getFirst() > c) {
                stack.removeFirst();
                k--;
            }
            stack.addFirst(c);
        }
        for(int i = 0; i < k; i++) {
            stack.removeFirst();
        }
        StringBuilder sb = new StringBuilder();
        boolean leadZero = true;
        while(!stack.isEmpty()) {
            if(leadZero && stack.getLast().equals('0')) {
                stack.removeLast();
                continue;
            }
            leadZero = false;
            sb.append(stack.removeLast());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
