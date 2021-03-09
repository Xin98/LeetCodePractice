package cn.codexin.questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by xinGao 2021/3/9
 */

public class Q1047_Remove_All_Adjacent_Duplicates_In_String {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new LinkedList<>();
        for(char c : S.toCharArray()) {
            if(stack.isEmpty() || !stack.peekLast().equals(c)){
                stack.offerLast(c);
            } else {
                stack.pollLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(c -> sb.append(c));
        return sb.toString();
    }
}
