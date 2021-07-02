package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2021/6/26
 */

public class Q0773_Sliding_Puzzle {
    private int[][] neighbors = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    public int slidingPuzzle(int[][] board) {
        Set<Integer> visited = new HashSet<>();
        int target = 123450;
        int init = 0;
        for (int[] row : board) {
            for (int col : row) {
                init = init * 10 + col;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(init);
        visited.add(init);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                if(pos == target) {
                    return depth;
                }
                int[] nextPoses = nextPoses(pos);
                for (int nextPos : nextPoses) {
                    if(visited.contains(nextPos)) {
                        continue;
                    }
                    queue.offer(nextPos);
                    visited.add(pos);
                }
            }
            depth++;
        }
        return -1;
    }

    private int[] nextPoses(int pos) {
        int[] nums = new int[6];
        int cur = 5;
        int zeroPos = 0;
        while (pos > 0 && cur >= 0) {
            nums[cur] = pos % 10;
            if(pos % 10 == 0) {
                zeroPos = cur;
            }
            pos /= 10;
            cur--;
        }
        List<Integer> nextPoses = new LinkedList<>();
        for (int nextZeroPos : neighbors[zeroPos]) {
            nums[zeroPos] = nums[nextZeroPos];
            nums[nextZeroPos] = 0;
            int nextPos = 0;
            for (int num : nums) {
                nextPos = nextPos * 10 + num;
            }
            nextPoses.add(nextPos);
            nums[nextZeroPos] = nums[zeroPos];
            nums[zeroPos] = 0;
        }
        return nextPoses.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Q0773_Sliding_Puzzle Q = new Q0773_Sliding_Puzzle();
        Q.slidingPuzzle(new int[][]{{3,2,4},{1,5,0}});
    }
}
