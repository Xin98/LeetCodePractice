package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/3
 */

public class Q0415_Add_String {
    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }
        int n = num1.length();
        int m = num2.length();
        int carry = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if(i <= m) {
                sum = num1.charAt(n-i) + num2.charAt(m-i) + carry - 2 * '0';
            } else {
                sum = num1.charAt(n-i) + carry - '0';
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if(carry != 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
