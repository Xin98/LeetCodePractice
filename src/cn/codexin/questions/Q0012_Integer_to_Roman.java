package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/14
 */

public class Q0012_Integer_to_Roman {
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int n = values.length;
        for (int i = 0; i < n; i++) {
            int value = values[i];
            String roman = romans[i];
            while(num >= value) {
                sb.append(roman);
                num -= value;
            }
            if(num == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
