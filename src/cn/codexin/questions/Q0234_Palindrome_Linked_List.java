package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/23
 */

public class Q0234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode endOfFirstList = getMidNode(head);
        ListNode startOfSecondList = reverseList(endOfFirstList.next);
        ListNode p = startOfSecondList;
        boolean ans = true;
        while(ans && p != null) {
            if(p.val != head.val) {
                ans = false;
            } else {
                p = p.next;
                head = head.next;
            }
        }
        reverseList(startOfSecondList);
        return ans;
    }
    public ListNode getMidNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
