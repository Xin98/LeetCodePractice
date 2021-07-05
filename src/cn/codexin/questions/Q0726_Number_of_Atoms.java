package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2021/7/5
 */

public class Q0726_Number_of_Atoms {
    String formula;
    int i, n;

    public String countOfAtoms(String formula) {
        this.formula = formula;
        this.i = 0;
        this.n = formula.length();
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());
        while (i < n) {
            char ch = formula.charAt(i);
            if(ch == '(') {
                i++;
                stack.push(new HashMap<>());
            } else if(ch == ')') {
                i++;
                Map<String, Integer> popMap = stack.pop();
                Map<String, Integer> topMap = stack.peek();
                int num = parseNum();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    Integer v = entry.getValue();
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + v * num);
                }
            } else {
                String atom = parseAtom();
                int num = parseNum();
                Map<String, Integer> topMap = stack.peek();
                topMap.put(atom, topMap.getOrDefault(atom, 0) + num);
            }
        }
        Map<String, Integer> map = stack.pop();
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int v = entry.getValue();
            sb.append(atom);
            if(v > 1) {
                sb.append(v);
            }
        }
        return sb.toString();
    }

    private String parseAtom() {
        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(i++));
        while (i < n && Character.isLowerCase(formula.charAt(i))) {
            sb.append(formula.charAt(i));
        }
        return sb.toString();
    }

    private int parseNum() {
        if(i == n || !Character.isDigit(formula.charAt(i))) {
            return 1;
        }
        int num = 0;
        while (i < n && Character.isDigit(formula.charAt(i))) {
            num = num * 10 + formula.charAt(i) - '0';
        }
        return num;
    }
}
