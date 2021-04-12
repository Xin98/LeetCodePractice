package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2021/4/12
 */

public class Q0179_Largest_Number {
    public String largestNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<>((a, b) -> {
            String ab = a + b, ba = b + a;
            return ba.compareTo(ab);
        });
        for (int num : nums) {
            queue.add(String.valueOf(num));
        }
        String res = "";
        while (!queue.isEmpty()) {
            String next = queue.poll();
            if("".equals(res) && "0".equals(next)) {
                res = "0";
                break;
            }
            res += next;
        }
        return res;
    }
}
