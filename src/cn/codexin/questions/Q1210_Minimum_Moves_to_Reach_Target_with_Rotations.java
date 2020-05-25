package cn.codexin.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xinGao 2020/5/25
 */

public class Q1210_Minimum_Moves_to_Reach_Target_with_Rotations {
    private int[][] dirs = {{0, 1, 0}, {1, 0, 0}, {0, 0, 1}, {0, 0, -1}};

    public int minimumMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        //[0, 0(0,0是蛇尾坐标), 0(0,是水平，1是垂直)] 代表着蛇尾部坐标为[0,0]，方向为水平

        queue.offer(new int[]{0, 0, 0});
        int[][][] visited = new int[m][n][2];
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            while (size > 0) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int[] newPos = new int[3];
                    newPos[0] = pos[0] + dir[0];
                    newPos[1] = pos[1] + dir[1];
                    newPos[2] = pos[2] + dir[2];
                    //判断蛇尾位置和蛇的方向是否合理
                    if (newPos[0] >= m || newPos[1] >= n || newPos[2] < 0 || newPos[2] > 1 ||
                            grid[newPos[0]][newPos[1]] == 1) {
                        continue;
                    }
                    //判断蛇头的位置是否合理
                    if (newPos[2] == 0 && (newPos[1] >= n - 1 || grid[newPos[0]][newPos[1] + 1] == 1) ||
                            newPos[2] == 1 && (newPos[0] >= m - 1 || grid[newPos[0] + 1][newPos[1]] == 1)) {
                        continue;
                    }
                    //额外判断 如果是旋转蛇需要判断蛇尾的斜下角是否有障碍
                    if (dir[2] != 0 && (pos[0] >= m - 1 || pos[1] >= n - 1 || grid[pos[0] + 1][pos[1] + 1] == 1)) {
                        continue;
                    }
                    //判断蛇处于的位置是否之前已经遍历过
                    if (visited[newPos[0]][newPos[1]][newPos[2]] == 1) continue;
                    //判断蛇是否达到了终点
                    if (newPos[0] == m - 1 && newPos[1] == n - 2 && newPos[2] == 0) return ans;
                    queue.offer(newPos);
                    visited[newPos[0]][newPos[1]][newPos[2]] = 1;
                }
                size--;
            }

        }
        return -1;
    }


}
/*
 * [
 * [0,0,1,0,0,0,0,0,0,0,0,0,0,0,0],
 * [0,1,0,1,1,0,0,1,0,0,0,0,1,0,0],
 * [0,1,0,0,0,0,1,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],
 * [0,0,0,0,0,0,1,1,0,0,0,0,0,0,0],
 * [0,0,0,0,0,0,0,0,0,1,0,1,0,0,0],
 * [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
 * [0,0,0,1,0,1,0,0,1,0,0,0,1,0,0],
 * [0,0,0,0,1,0,0,0,0,0,0,0,0,1,0],
 * [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
 * [0,0,0,1,0,0,0,0,0,0,0,0,0,0,0],
 * [1,0,1,1,0,0,0,0,0,0,0,0,0,0,0],
 * [0,0,0,0,0,0,0,0,0,0,0,0,0,1,0],
 * [1,0,0,0,0,0,1,0,0,0,1,0,0,0,1],
 * [0,0,1,0,1,0,0,0,0,0,0,0,0,0,0]
 * ]

 * */
