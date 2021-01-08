package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/8
 */

public class Q0189_Rotate_Array {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int circles = gcd(n, k);
        for(int i = 0; i < circles; i++) {
            int cur = i;
            int pre = nums[cur];
            do {
                int next = (cur + k) % n;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                cur = next;
            } while(cur != i);
        }
    }
    public int gcd(int x, int y) {
        if(x < y) {
            return gcd(y, x);
        }
        if(y == 0) {
            return x;
        }
        return x % y == 0 ? y : gcd(y, x % y);
    }
}
