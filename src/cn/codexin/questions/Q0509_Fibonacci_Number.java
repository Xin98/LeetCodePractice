package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/4
 */

public class Q0509_Fibonacci_Number {
    private int[] memo;
    public int fib(int n) {
        memo = new int[n + 1];
        return fibonacci(n);
    }
    public int fibonacci(int n) {
        if(n < 2) {
            return n;
        }
        if(memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n];
    }
}
