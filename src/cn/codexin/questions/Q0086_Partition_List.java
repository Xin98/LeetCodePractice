package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/3
 */

public class Q0086_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode p = less;
        ListNode q = greater;
        while(head != null) {
            if(head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        p.next = greater.next;
        q.next = null;
        return less.next;
    }
}
