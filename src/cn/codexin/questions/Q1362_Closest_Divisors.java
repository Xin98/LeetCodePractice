package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/1
 */

public class Q1362_Closest_Divisors {
    public int[] closestDivisors(int num) {
        int sqrt = (int)Math.sqrt(num+2);
        for (int i = sqrt; i > 0; i--) {
            if((num + 2) % i == 0) return new int[]{i, (num + 2) / i};
            if((num + 1) % i == 0) return new int[]{i, (num + 1) / i};
        }
        return new int[]{-1, -1};
    }
}
