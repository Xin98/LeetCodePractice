package cn.codexin.questions;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xinGao 2020/4/14
 */



public class Q0445_Add_Two_Numbers_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        ListNode ans = null;
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0, sum = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            sum = 0;
            if(!s1.isEmpty()) sum += s1.poll();
            if(!s2.isEmpty()) sum += s2.poll();
            sum += carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode tmp = new ListNode(sum);
            tmp.next = ans;
            ans = tmp;
        }
        return ans;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
