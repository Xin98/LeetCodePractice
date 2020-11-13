package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/13
 */

public class Q0328_Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode even = fast;
        ListNode odd = head;
        while(slow != null && fast != null) {
            slow.next = fast.next;
            slow = fast;
            fast = fast.next;
        }
        while(odd.next != null) {
            odd = odd.next;
        }
        odd.next = even;
        return head;
    }
}
