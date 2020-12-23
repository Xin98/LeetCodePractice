package cn.codexin.questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xinGao 2020/12/23
 */

public class Q0970_Powerful_Integers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> xs = new LinkedList<>();
        List<Integer> ys = new LinkedList<>();
        int xi = 1, yi = 1;
        while(xi < bound) {
            xs.add(xi);
            if(x == 1) {
                break;
            }
            xi *= x;
        }
        while(yi < bound) {
            ys.add(yi);
            if(y == 1) {
                break;
            }
            yi *= y;
        }
        Set<Integer> set = new HashSet<>();
        for(int _xi : xs) {
            for(int _yi : ys) {
                if(_xi + _yi > bound) {
                    break;
                }
                set.add(_xi + _yi);
            }
        }
        return set.stream().collect(Collectors.toList());
    }
}
