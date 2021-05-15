package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/5/15
 */

public class Q0013_Roman_to_Integer {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans = 0;
        int n = s.length();
        int last = map.get(s.charAt(0));
        for (int i = 1; i < n; i++) {
            int now = map.get(s.charAt(i));
            if(now > last) {
                ans -= last;
            } else {
                ans += last;
            }
            last = now;
        }
        ans += last;
        return ans;
    }
}
