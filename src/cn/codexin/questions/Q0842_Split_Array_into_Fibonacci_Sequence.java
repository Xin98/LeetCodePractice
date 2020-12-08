package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/12/8
 */

public class Q0842_Split_Array_into_Fibonacci_Sequence {
    public List<Integer> splitIntoFibonacci(String S) {
        int n = S.length();
        List<Integer> ans = new LinkedList<>();
        for(int i = 1; i <= 10; i++) {
            for(int j = 1; j <= 10; j++) {
                ans.clear();
                if(!validate(S, i, j)) {
                    continue;
                }
                int a = Integer.valueOf(S.substring(0, i));
                int b = Integer.valueOf(S.substring(i, i + j));
                ans.add(a);
                ans.add(b);
                int nextIndex = i + j;

                while(nextIndex < n) {
                    long c = (long)a + b;
                    if(c > Integer.MAX_VALUE) {
                        break;
                    }
                    String tmp = String.valueOf(c);
                    if(nextIndex + tmp.length() > n) {
                        break;
                    }
                    if(!S.substring(nextIndex, nextIndex + tmp.length()).equals(tmp)) {
                        break;
                    }
                    ans.add(Integer.valueOf(tmp));
                    if(nextIndex + tmp.length() == n) {
                        return ans;
                    }
                    nextIndex += tmp.length();
                    a = b;
                    b = Integer.valueOf(tmp);
                }
            }
        }
        ans.clear();
        return ans;
    }
    public boolean validate(String s, int i, int j) {
        int n = s.length();
        if(i + j >= n) {
            return false;
        }
        if(s.charAt(0) == '0' && i > 1) {
            return false;
        }
        if(s.charAt(i) == '0' && j > 1) {
            return false;
        }
        long a = Long.valueOf(s.substring(0, i));
        long b = Long.valueOf(s.substring(i, i + j));
        if(a > Integer.MAX_VALUE || b > Integer.MAX_VALUE) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q0842_Split_Array_into_Fibonacci_Sequence Q = new Q0842_Split_Array_into_Fibonacci_Sequence();
        Q.splitIntoFibonacci("0123");
    }
}
