package cn.codexin.questions;

import com.sun.deploy.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/12/18
 */

public class Q0906_Super_Palindromes {
    public int superpalindromesInRange(String L, String R) {
        long lo = Long.valueOf(L);
        long hi = Long.valueOf(R);
        List<Long> palindrome = new LinkedList<>();
        for (long i = 1; i < 10; i++) {
            palindrome.add(i);
        }
        for(int i = 1; i < 10000; i++) {
            String left = String.valueOf(i);
            String right = new StringBuilder(left).reverse().toString();
            palindrome.add(Long.valueOf(left + right));
            for (int j = 0; j < 10; j++) {
                palindrome.add(Long.valueOf(left + String.valueOf(j) + right));
            }
        }
        int ans = 0;
        for(long num : palindrome) {
            long square = num * num;
            if(square < lo || square > hi) {
                continue;
            }
            if(isSuperPalindrome(Long.toString(square))) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isSuperPalindrome(String num) {
        StringBuilder sb = new StringBuilder(num);
        return num.equals(sb.reverse().toString());
    }
}
