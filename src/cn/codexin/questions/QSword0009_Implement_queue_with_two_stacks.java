package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2020/6/30
 */

public class QSword0009_Implement_queue_with_two_stacks {
    class CQueue {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        private int size;
        public CQueue() {
            size = 0;
        }

        public void appendTail(int value) {
            stack1.push(value);
            size++;
        }

        public int deleteHead() {
            if(size == 0) return -1;
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            size--;
            return stack2.pop();
        }
    }
}
