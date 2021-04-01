package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2021/4/1
 */

public class Q1006_Clumsy_Factorial {
    public int clumsy(int N) {
        Deque<Long> stack = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(!stack.isEmpty()) {
                int ops = i % 4;
                if(ops == 1) {
                    stack.push(stack.pop() * (N - i));
                } else if(ops == 2) {
                    stack.push(stack.pop() / (N - i));
                } else if(ops == 3) {
                    stack.push(stack.pop() + (N - i));
                } else {
                    stack.push((long)i - N);
                }
            } else {
                stack.push((long)N - i);
            }
        }
        return stack.stream().reduce((x, y)->x + y).get().intValue();
    }
}
