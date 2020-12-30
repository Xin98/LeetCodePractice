package cn.codexin.questions;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xinGao 2020/12/30
 */

public class Q1046_Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>((x, y)->y - x);
        for(int stone : stones) {
            q.offer(stone);
        }
        while(!q.isEmpty()) {
            int one = q.poll();
            if(q.isEmpty()) {
                return one;
            }
            int two = q.poll();
            if(one != two) {
                q.offer(Math.abs(one - two));
            }
        }
        return 0;
    }
}
