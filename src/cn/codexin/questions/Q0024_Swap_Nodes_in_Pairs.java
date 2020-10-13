package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/13
 */

public class Q0024_Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if(head == null) {
            return null;
        }
        ListNode p = head, q = head.next, pre = dummy;
        while(p != null && q != null) {
            pre.next = q;
            p.next = q.next;
            q.next = p;
            pre = p;
            p = p.next;
            if(p == null) {
                break;
            }
            q = p.next;
        }
        return dummy.next;
    }
}
