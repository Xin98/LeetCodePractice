package cn.codexin.questions;

/**
 * Created by xinGao 2021/2/23
 */

public class Q1052_Grumpy_Bookstore_Owner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int sum = 0;
        for(int i = 0; i < X; i++) {
            sum += customers[i];
        }
        for(int i = X; i < n; i++) {
            sum += customers[i] * (1 - grumpy[i]);
        }
        int ans = sum;
        for(int i = X; i < n ; i++) {
            if(grumpy[i] == 1) {
                sum += customers[i];
            }
            if(grumpy[i - X] == 1) {
                sum -= customers[i - X];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
