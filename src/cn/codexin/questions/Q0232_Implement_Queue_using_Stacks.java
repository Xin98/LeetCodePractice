package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2021/3/5
 */

public class Q0232_Implement_Queue_using_Stacks {

    class MyQueue {
        Deque<Integer> in;
        Deque<Integer> out;
        /** Initialize your data structure here. */
        public MyQueue() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            in.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return out.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(out.isEmpty()) {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
