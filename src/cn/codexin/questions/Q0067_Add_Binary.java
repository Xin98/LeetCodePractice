package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/23
 */

public class Q0067_Add_Binary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        int n = Math.max(aLen, bLen);
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < aLen ? (a.charAt(aLen - 1 - i) - '0') : 0;
            carry += i < aLen ? (b.charAt(aLen - 1 - i) - '0') : 0;
            sb.append((char)('0' + (carry % 2)));
            carry /= 2;
        }
        if(carry > 0) sb.append('1');
        return sb.reverse().toString();
    }
}
