package cn.codexin.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xinGao 2020/4/30
 */

public class Q0202_Happy_Number {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            int next = 0;
            for(;n > 0;n = n/10){
                int tmp = n % 10;
                next += tmp * tmp;
            }
            if(next == 1) return true;
            n = next;
        }
        return false;
    }
}
