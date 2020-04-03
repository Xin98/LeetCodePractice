package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/3
 */

public class Q0008_String_to_Integer {
    public int myAtoi(String str) {
        str = str.trim();
        boolean neg = false;
        int len = str.length(), ans = 0;
        for(int i = 0; i < len; i++){
            if(i == 0 && str.charAt(i) == '-') {
                neg = true;
                continue;
            }
            if(i == 0 && str.charAt(i) == '+') continue;
            int c = str.charAt(i) - '0';
            if(c < 0 || c > 9) break;
            //思路一 转化为long再判断
//            long tmp = (long)ans * 10 + c;
//            if(tmp > Integer.MAX_VALUE) return neg == true ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//            ans = (int)tmp;
            //思路二 转化为Integer.MAX_VALUE / 10
            if((Integer.MAX_VALUE - c) / 10 != ans) return neg == true ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            ans = ans * 10 + c;
        }
        return neg == true ? -ans : ans;
    }

    public static void main(String[] args) {
        Q0008_String_to_Integer q0008_string_to_integer = new Q0008_String_to_Integer();
        q0008_string_to_integer.myAtoi("-6147483648");
    }
}
