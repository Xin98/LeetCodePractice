package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2020/5/12
 */

public class Q0155_Min_Stack {
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
            min = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if(min.size() == 0 || min.peek() > x) min.push(x);
            else min.push(min.peek());
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

}
