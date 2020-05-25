package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/25
 */

public class Q1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {
    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        for(;n > 0; n = n / 10){
            int m = n % 10;
            mul *= m;
            sum += m;
        }
        return mul - sum;
    }
}
