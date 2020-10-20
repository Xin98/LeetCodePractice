package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/20
 */

public class Q0143_Reorder_List {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode mid = getMidNode(head);
        ListNode reversedList = reverseList(mid.next);
        mid.next = null;
        head = mergeTwoList(head, reversedList);
    }
    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummpy = new ListNode(0);
        ListNode cur = dummpy;
        while(list1 != null || list2 != null) {
            if(list1 != null) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }
            if(list2 != null) {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        return dummpy.next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode dummpy = new ListNode(0);
        ListNode tmp;
        dummpy.next = null;
        while(head != null) {
            tmp = head.next;
            head.next = dummpy.next;
            dummpy.next = head;
            head = tmp;
        }
        return dummpy.next;
    }

    public ListNode getMidNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null) {
            fast = fast.next;
            if(fast == null || fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
