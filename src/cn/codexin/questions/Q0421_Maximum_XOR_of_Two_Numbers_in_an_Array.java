package cn.codexin.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xinGao 2021/5/16
 */

public class Q0421_Maximum_XOR_of_Two_Numbers_in_an_Array {
    private final int HIGH_BIT = 30;
    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            Set<Integer> seen = new HashSet<>();
            for (int num : nums) {
                seen.add(num >> k);
            }
            int x_next = (x << 1) + 1;
            boolean found = false;
            for (int num : nums) {
                if(seen.contains(x_next ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            if(found) {
                x = x_next;
            } else {
                x = x_next - 1;
            }
        }
        return x;
    }
}
