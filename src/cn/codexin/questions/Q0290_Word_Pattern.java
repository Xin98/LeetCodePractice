package cn.codexin.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xinGao 2020/6/6
 */

public class Q0290_Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        char[] patternChars = pattern.toCharArray();
        int n = s.length;
        if(n != patternChars.length) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> strSet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(patternChars[i])) {
                if(strSet.contains(s[i])) return false;
                map.put(patternChars[i], s[i]);
                strSet.add(s[i]);

            } else {
                if(s[i].equals(map.get(patternChars[i]))) continue;
                return false;
            }
        }
        return true;
    }
}
