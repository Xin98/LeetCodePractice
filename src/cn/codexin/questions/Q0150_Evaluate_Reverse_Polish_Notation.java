package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2021/3/20
 */

public class Q0150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if("+".equals(token)){
                stack.push(stack.pop() + stack.pop());
            } else if("-".equals(token)){
                stack.push(-(stack.pop() - stack.pop()));
            } else if("*".equals(token)){
                stack.push(stack.pop() * stack.pop());
            } else if("/".equals(token)){
                stack.push((int)((double)1 / stack.pop() * stack.pop()));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
