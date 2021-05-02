package cn.codexin.questions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xinGao 2021/5/2
 */

public class Q0554_Brick_Wall {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(List<Integer> w: wall){
            int sum = 0;
            for(int width: w) {
                sum += width;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            map.remove(sum);
        }

        return n - map.values().stream().max(Comparator.comparingInt(a -> a)).get();

    }
}
