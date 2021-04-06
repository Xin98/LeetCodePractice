package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/4/4
 */

public class Q0781_Rabbits_in_Forest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : answers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int x = e.getValue();
            int y = e.getKey();
            ans += (x + y)/(y + 1) * (y + 1);
        }
        return ans;
    }
}
