package cn.codexin.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xinGao 2021/2/1
 */

public class Q0888_Fair_Candy_Swap {
    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int sumA = 0;
        for(int candy : A) {
            sumA += candy;
            set.add(candy);
        }
        int sumB = 0;
        for(int candy : B) {
            sumB += candy;
        }
        int diff = sumA - sumB;
        for(int candy : B) {
            if(set.contains(candy + diff / 2)) {
                return new int[]{candy + diff / 2, candy};
            }
        }
        return new int[]{0, 0};
    }
}
