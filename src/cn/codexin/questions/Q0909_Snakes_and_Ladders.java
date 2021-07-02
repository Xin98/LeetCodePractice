package cn.codexin.questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xinGao 2021/6/27
 */

public class Q0909_Snakes_and_Ladders {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(1);
        visited.add(1);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                if(pos == N * N) {
                    return ans;
                }
                for (int j = pos + 1; j <= pos + 6 && j <= N * N; j++) {
                    int[] rc = getCoordinate(j, N);
                    if(board[rc[0]][rc[1]] != -1) {
                        if(!visited.contains(board[rc[0]][rc[1]])) {
                            queue.offer(board[rc[0]][rc[1]]);
                            visited.add(board[rc[0]][rc[1]]);
                        }
                    } else if(!visited.contains(j)){
                        queue.offer(j);
                        visited.add(j);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
    private int[] getCoordinate(int num, int N) {
        num--;
        int row = num / N;
        int col = num % N;
        return row % 2 == 0? new int[]{N - 1 - row, col}: new int[]{N - 1 - row, N - 1 - col};
    }
}
