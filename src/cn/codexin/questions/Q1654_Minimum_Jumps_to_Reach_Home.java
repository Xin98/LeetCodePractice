package cn.codexin.questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xinGao 2020/12/4
 */

public class Q1654_Minimum_Jumps_to_Reach_Home {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for(int f : forbidden) {
            forbiddenSet.add(f);
        }
        // (step, pos, isBackward)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0});
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            if(pos[1] == x) {
                return pos[0];
            }
            if(pos[1] + a < 6000 && !forbiddenSet.contains(pos[1] + a)) {
                forbiddenSet.add(pos[1] + a);
                queue.offer(new int[]{pos[0] + 1, pos[1] + a, 0});
            }
            if(pos[2] == 0 && pos[1] > b && !forbiddenSet.contains(pos[1] - b)) {
                queue.offer(new int[]{pos[0] + 1, pos[1] - b, 1});
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Q1654_Minimum_Jumps_to_Reach_Home Q = new Q1654_Minimum_Jumps_to_Reach_Home();
        Q.minimumJumps(new int[]{14,4,18,1,15}, 3, 15, 9);
    }
}
