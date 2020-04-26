package cn.codexin.questions;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xinGao 2020/4/26
 */

public class Q0023_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<ListNode>((x, y) -> x.val - y.val);
        for (ListNode list : lists) {
            if(list != null){
                queue.offer(list);
            }
        }
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null) queue.offer(node.next);
        }
        return ans.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
