package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/18
 */

public class Q0019_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode fast = dummpy, slow = dummpy;
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummpy.next;
    }
}
