package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/12/27
 */

public class Q0205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        return restruct(s).equals(restruct(t));
    }
    public String restruct(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                sb.append(idx);
                map.put(c, idx++);
            }
        }
        return sb.toString();
    }
}
