package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/9
 */

public class Q0141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode s = head.next;
        if(s == null) {
            return false;
        }
        ListNode f = head.next.next;
        if(f == null) {
            return false;
        }
        while(s != null && f != null && f.next != null) {
            if(s == f) {
                return true;
            }
            s = s.next;
            f = f.next.next;
        }
        return false;
    }
}
