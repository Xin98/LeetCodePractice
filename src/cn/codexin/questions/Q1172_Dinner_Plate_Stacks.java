package cn.codexin.questions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xinGao 2020/10/21
 */

public class Q1172_Dinner_Plate_Stacks {
    class DinnerPlates {
        private TreeMap<Integer, Deque<Integer>> pushTree;
        private TreeMap<Integer, Deque<Integer>> popTree;
        private int capacity;
        public DinnerPlates(int capacity) {
            this.capacity = capacity;
            pushTree = new TreeMap<>();
            popTree = new TreeMap<>();
        }

        public void push(int val) {
            if(pushTree.isEmpty()) {
                pushTree.put(popTree.size(), new ArrayDeque<>());
            }
            Map.Entry<Integer, Deque<Integer>> entry = pushTree.firstEntry();
            int idx = entry.getKey();
            Deque<Integer> stack = entry.getValue();
            stack.push(val);
            if(stack.size() == 1) {
                popTree.put(idx, stack);
            }
            if(stack.size() == capacity) {
                pushTree.remove(idx);
            }
        }

        public int pop() {
            if(popTree.isEmpty()) {
                return -1;
            }
            Map.Entry<Integer, Deque<Integer>> entry = popTree.lastEntry();
            int idx = entry.getKey();
            Deque<Integer> stack = entry.getValue();
            return doPop(idx, stack);
        }

        public int popAtStack(int index) {
            if(!popTree.containsKey(index)) {
                return -1;
            }
            Deque<Integer> stack = popTree.get(index);
            return doPop(index, stack);
        }

        public int doPop(int index, Deque<Integer> stack) {
            int ans = stack.pop();
            if(stack.size() == 0) {
                popTree.remove(index);
            } else if(stack.size() == capacity - 1) {
                pushTree.put(index, stack);
            }
            return ans;
        }
    }
}
