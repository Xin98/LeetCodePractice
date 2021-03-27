package cn.codexin.questions;

/**
 * Created by xinGao 2021/3/27
 */

public class Q0061_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        ListNode cur = head, pre = head;
        int cnt = 0;
        while(k-- > 0) {
            if(cur != null) {
                cur = cur.next;
                cnt++;

            } else {
                cur = pre.next;
                k = k % cnt;
                cnt = 0;
            }
        }
        if(cur == null) {
            return head;
        }
        while(cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        cur.next = head;
        head = pre.next;
        pre.next = null;
        return head;
    }
}
