package cn.codexin.questions;

/**
 * Created by xinGao 2021/6/4
 */

public class Q0160_Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2) {
            if(p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if(p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
