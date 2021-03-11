package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2021/3/11
 */

public class Q0227_Basic_Calculator_II {
    public int calculate(String s) {
        Deque<Long> numstk = new LinkedList<>();
        char preSign = '+';
        int n = s.length();
        long num = 0;
        for(int i = 0; i < n; i++) {
            if(Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (i == n - 1 || (s.charAt(i) != ' ' && !Character.isDigit(s.charAt(i)))) {
                if(preSign == '+') {
                    numstk.push(num);
                } else if(preSign == '-') {
                    numstk.push(-num);
                } else if(preSign == '*') {
                    numstk.push(numstk.pop() * num);
                } else if(preSign == '/') {
                    numstk.push(numstk.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        return numstk.stream().reduce((a, b)->a + b).get().intValue();
    }
}
