package cn.codexin.questions;

/**
 * Created by xinGao 2021/3/26
 */

public class Q0083_Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
