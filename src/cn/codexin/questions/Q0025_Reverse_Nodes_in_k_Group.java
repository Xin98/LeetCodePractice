package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/16
 */

public class Q0025_Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        for(;head != null;){
            ListNode tail = pre;
            for(int i = k; i >0; i--){
                tail = tail.next;
                if(tail == null) return dummy.next;
            }
            ListNode next = tail.next;
            //{new Head,  new Tail}
            ListNode[] listNodes = reverseList(head, tail);
            pre.next = listNodes[0];
            pre = listNodes[1];
            head = next;
            pre.next = head;
        }
        return dummy.next;
    }
    //翻转 [head,tail] 之间的链表
    public ListNode[] reverseList(ListNode head, ListNode tail){
        ListNode p = head;
        ListNode pre = tail.next;
        while(pre != tail) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }
}
