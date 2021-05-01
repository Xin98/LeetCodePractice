package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2021/5/1
 */

public class Q0690_Employee_Importance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> imp = new HashMap<>();
        Map<Integer, List<Integer>> sub = new HashMap<>();
        Employee target = null;
        for(Employee e : employees) {
            imp.put(e.id, e.importance);
            sub.put(e.id, e.subordinates);
        }
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(id);
        while(!stack.isEmpty()) {
            int _id = stack.pop();
            ans += imp.get(_id);
            for(Integer i : sub.get(_id)){
                stack.push(i);
            }
        }
        return ans;
    }
}
