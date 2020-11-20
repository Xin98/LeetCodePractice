package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/20
 */

public class Q0147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastSorted = head, cur = head.next;
        ListNode pre;
        while(cur != null) {
            if(lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                pre = dummy;
                while(pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }
}
