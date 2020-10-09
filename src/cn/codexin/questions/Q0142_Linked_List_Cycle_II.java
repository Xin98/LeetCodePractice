package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/9
 */

public class Q0142_Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode intersectNode = getIntersectNode(head);
        if(intersectNode == null) {
            return null;
        }
        ListNode p = head, q = intersectNode;
        while(p != q) {
            p = p.next;
            q= q.next;
        }
        return p;
    }
    public ListNode getIntersectNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return slow;
            }
        }
        return null;

    }
}
