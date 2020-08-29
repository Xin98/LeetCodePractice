package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/29
 */

public class Q0214_Shortest_Palindrome {
    public String shortestPalindrome(String s) {
        int base = 58;
        int mod = Integer.MAX_VALUE - base;
        int n = s.length();
        int left = 0, right = 0, mul = 1;
        int best = -1;
        for (int i = 0; i < n; i++) {
            left = (int)(((long) left * base + getValue(s.charAt(i))) % mod);
            right = (int)((right + (long) mul * getValue(s.charAt(i))) % mod);
            if(left == right) {
                best = i;
            }
            mul = (int) (((long)mul * base) % mod);
        }
        String add = best == n - 1 ? "" : s.substring(best + 1);
        StringBuilder sb = new StringBuilder(add).reverse();
        return sb.toString() + s;
    }

    public int getValue(char c) {
        return c - 'A';
    }
    public static void main(String[] args) {
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'z' - (int)'A');
    }
}
