package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/21
 */

public class Q0148_Sort_List {
    public ListNode sortList(ListNode head) {
        ListNode node = head;
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for(int subLen = 1; subLen < length; subLen <<= 1) {
            ListNode pre = dummyHead;
            ListNode cur = dummyHead.next;
            while(cur != null) {
                ListNode head1 = cur;
                for(int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for(int i = 1; i < subLen && cur != null; i++) {
                    cur = cur.next;
                }
                ListNode next= null;
                if(cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                pre.next = merge(head1, head2);
                while(pre.next != null) {
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                pre.next = head1;
                head1 = head1.next;
            } else {
                pre.next = head2;
                head2 = head2.next;
            }
            pre = pre.next;
        }
        if(head1 != null) {
            pre.next = head1;
        }
        if(head2 != null) {
            pre.next = head2;
        }
        return dummyHead.next;
    }
}
