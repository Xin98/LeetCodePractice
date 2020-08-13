package cn.codexin.questions;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by xinGao 2020/8/14
 */

public class Q0020_Valid_Parentheses {
    public boolean isValid(String s) {
        int n = s.length();
        if(n == 0) {
            return true;
        }
        if(n % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '{' || c == '(') {
                stack.push(map.get(c));
            } else {
                if(stack.isEmpty() || !stack.pop().equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
