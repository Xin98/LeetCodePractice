package cn.codexin.questions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by xinGao 2020/10/23
 */

public class Q1585_Check_If_String_Is_Transformable_With_Substring_Sort_Operations {
    public boolean isTransformable(String s, String t) {
        Map<Integer, Queue<Integer>> pos = new HashMap<>();
        int n = s.length(), m = t.length();
        if(n != m) {
            return false;
        }
        for(int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            if(!pos.containsKey(num)) {
                pos.put(num, new LinkedList<>());
            }
            pos.get(num).offer(i);
        }
        for(int i = 0; i < m; i++) {
            int num = t.charAt(i) - '0';
            if(!pos.containsKey(num)) {
                return false;
            }
            int numPos = pos.get(num).poll();
            for(int j = 0; j < num; j++) {
                if(!pos.containsKey(j)) {
                    continue;
                }
                if(pos.get(j).peek() < numPos) {
                    return false;
                }
            }
            if(pos.get(num).size() == 0) {
                pos.remove(num);
            }
        }
        return true;
    }
}
