package cn.codexin.questions;

/**
 * Created by xinGao 2021/7/21
 */

public class QSword_0052_First_Common_Node_of_Two_LinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int na = getLength(headA);
        int nb = getLength(headB);
        if(na > nb) {
            return getIntersectionNode(headB, headA);
        }
        int dis = nb - na;
        while (dis > 0) {
            dis--;
            headB = headB.next;
        }
        while (na > 0) {
            na--;
            if(headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return headA;
    }

    private int getLength(ListNode headA) {
        int len = 0;
        while (headA != null) {
            len++;
            headA = headA.next;
        }
        return len;
    }

}
