package cn.codexin.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinGao 2021/1/14
 */

public class Q1018_Binary_Prefix_Divisible_By_5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int n = A.length;
        int acc = 0;
        List<Boolean> ans = new   ArrayList<>(n);
        for(int num : A) {
            acc = ((acc << 1) + num) % 5;
            if(acc == 0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
