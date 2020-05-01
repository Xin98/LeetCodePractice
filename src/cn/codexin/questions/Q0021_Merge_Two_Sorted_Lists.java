package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/1
 */

public class Q0021_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode ptr = ans;
        for(;l1 != null && l2!=null;){
            if(l1.val < l2.val){
                ptr.next = l1;
                l1 = l1.next;
            }else{
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        for(;l1!=null; l1 = l1.next, ptr = ptr.next){ptr.next = l1;}
        for(;l2!=null; l2 = l2.next, ptr = ptr.next){ptr.next = l2;}
        return ans.next;
    }
}
