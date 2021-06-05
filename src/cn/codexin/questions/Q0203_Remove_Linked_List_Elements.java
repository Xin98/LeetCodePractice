package cn.codexin.questions;

/**
 * Created by xinGao 2021/6/5
 */

public class Q0203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if(p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }

        }
        return dummy.next;
    }
}
