package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2021/3/23
 */

public class Q0341_Flatten_Nested_List_Iterator {
    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
    class NestedIterator implements Iterator<Integer> {
        Deque<Iterator<NestedInteger>> stack;
        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new LinkedList<>();
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return stack.peek().next().getInteger();
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty()) {
                Iterator<NestedInteger> it = stack.peek();
                if(!it.hasNext()) {
                    stack.pop();
                    continue;
                } else {
                    NestedInteger nest = it.next();
                    if(nest.isInteger()) {
                        List<NestedInteger> list = new ArrayList<>();
                        list.add(nest);
                        stack.push(list.iterator());
                        return true;
                    }
                    stack.push(nest.getList().iterator());
                }
            }
            return false;

        }
    }
}
