package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/4
 */

public class Q0002_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        int cn = 0;
        while(l1 != null || l2 != null || cn != 0) {
            int val1 = (l1 != null ? l1.val : 0);
            int val2 = (l2 != null ? l2.val : 0);
            cur.next = new ListNode((val1 + val2 + cn) % 10);
            cn = (val1 + val2 + cn) / 10;
            cur = cur.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }
}
