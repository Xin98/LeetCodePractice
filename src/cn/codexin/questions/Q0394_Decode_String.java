package cn.codexin.questions;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by xinGao 2020/5/28
 */

public class Q0394_Decode_String {
    public String decodeString(String s) {
        char[] sCharArray = s.toCharArray();
        //数字栈
        Stack<Integer> dupStack = new Stack<>();
        //字符栈
        Stack<String> strStack = new Stack<>();
        int times = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : sCharArray) {
            if(c >= '0' && c <= '9') {
                times = times * 10 + c - '0';
            } else if(c == '[') {
                dupStack.push(times);
                times = 0;
                strStack.push(sb.toString());
                sb = new StringBuilder();

            } else if (c == ']'){
                String tmp = String.join("", Collections.nCopies(dupStack.pop(), sb.toString()));
                sb = new StringBuilder(strStack.pop() + tmp);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
