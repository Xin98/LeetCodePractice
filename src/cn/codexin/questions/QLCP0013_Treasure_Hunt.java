package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xinGao 2020/7/29
 */

public class QLCP0013_Treasure_Hunt {
    private int[] dx = new int[]{1,-1,0,0};
    private int[] dy = new int[]{0,0,1,-1};
    private int n;
    private int m;
    public int minimalSteps(String[] maze) {
        n = maze.length;
        m = maze[0].length();
        // 机关位置记录 (x,y)
        List<int[]> buttons = new LinkedList<>();
        // 石头位置记录 (x,y)
        List<int[]> stones = new LinkedList<>();
        // 开始和结束位置 (x,y)
        int[] start = new int[2];
        int[] target = new int[2];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char position = maze[i].charAt(j);
                if(position == 'S') {
                    // 记录开始坐标
                    start[0] = i;
                    start[1] = j;
                } else if(position == 'T') {
                    // 记录结束坐标
                    target[0] = i;
                    target[1] = j;
                } else if(position == 'M') {
                    // 记录机关位置
                    buttons.add(new int[]{i, j});
                } else if(position == 'O') {
                    // 记录石头位置
                    stones.add(new int[] {i,j});
                }
            }
        }

        int buttonSize = buttons.size();
        int stoneSize = stones.size();
        int[][] startDict = bfs(start[0], start[1], maze);
        if(buttonSize == 0) {
            // 没有机关直接返回 起点到终点的长度
            return startDict[target[0]][target[1]];
        }
        // 机关到[机关(0-buttonSize-1)/起点(buttonSize)/终点(buttonSize+1)]的最短距离
        int[][] button2SpecialPosMinLen = new int[buttonSize][buttonSize + 2];
        for (int i = 0; i < buttonSize; i++) {
            Arrays.fill(button2SpecialPosMinLen[i], -1);
        }
        int[][][] eachButton2NormalPosMinLen = new int[buttonSize][][];
        for (int i = 0; i < buttonSize; i++) {
            // 记录机关i到各个点的最短距离
            eachButton2NormalPosMinLen[i] = bfs(buttons.get(i)[0], buttons.get(i)[1], maze);
            // 从机关i直接到终点不需要拿石头，直接拿最短距离即可
            button2SpecialPosMinLen[i][buttonSize+1] = eachButton2NormalPosMinLen[i][target[0]][target[1]];
        }
        for (int i = 0; i < buttonSize; i++) {
            int tmp = -1;
            for (int j = 0; j < stoneSize; j++) {
                int[] stonePos = stones.get(j);
                // 起点--石头的距离
                int start2StoneDis = startDict[stonePos[0]][stonePos[1]];
                // 石头--机关的距离
                int stone2ButtonDis = eachButton2NormalPosMinLen[i][stonePos[0]][stonePos[1]];
                if(start2StoneDis != -1 && stone2ButtonDis != -1) {
                    // 起点--石头--机关连通
                    if(tmp == -1 || tmp > start2StoneDis + stone2ButtonDis) {
                        tmp = start2StoneDis + stone2ButtonDis;
                    }
                }
            }
            // 起点 拿着石头 到 机关i 的最短距离
            button2SpecialPosMinLen[i][buttonSize] = tmp;
            for (int j = i + 1; j < buttonSize; j++) {
                int mn = -1;
                for (int k = 0; k < stoneSize; k++) {
                    int[] stonePos = stones.get(k);
                    // 机关i--石头k的距离
                    int button2StoneDis = eachButton2NormalPosMinLen[i][stonePos[0]][stonePos[1]];
                    // 石头k--机关j的距离
                    int stone2ButtonDis = eachButton2NormalPosMinLen[j][stonePos[0]][stonePos[1]];
                    if(button2StoneDis != -1 && stone2ButtonDis != -1) {
                        // 机关i--石头k--机关j连通
                        if(mn == -1 || mn > button2StoneDis + stone2ButtonDis) {
                            mn = button2StoneDis + stone2ButtonDis;
                        }
                    }
                    // 机关i -- 石头k -- 机关i 的距离
                    button2SpecialPosMinLen[i][j] = mn;
                    button2SpecialPosMinLen[j][i] = mn;
                }
            }
        }
        // 无法拿到宝藏的情况, 任意的机关没办法触发
        for (int i = 0; i < buttonSize; i++) {
            // 起点无法到达机关i 或者 机关i无法到达终点
            if(button2SpecialPosMinLen[i][buttonSize] == -1 ||
                button2SpecialPosMinLen[i][buttonSize+1] == -1) {
                return -1;
            }
        }

        // dp 数组， -1 代表没有遍历到
        int[][] dp = new int[1 << buttonSize][buttonSize];
        for (int i = 0; i < 1 << buttonSize; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < buttonSize; i++) {
            dp[1 << i][i] = button2SpecialPosMinLen[i][buttonSize];
        }

        // 由于更新的状态都比未更新的大，所以直接从小到大遍历即可
        for (int mask = 1; mask < (1 << buttonSize); mask++) {
            for (int i = 0; i < buttonSize; i++) {
                // 当前 dp 是合法的
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < buttonSize; j++) {
                        // j 不在 mask 里
                        if ((mask & (1 << j)) == 0) {
                            int next = mask | (1 << j);
                            if (dp[next][j] == -1 || dp[next][j] > dp[mask][i] + button2SpecialPosMinLen[i][j]) {
                                dp[next][j] = dp[mask][i] + button2SpecialPosMinLen[i][j];
                            }
                        }
                    }
                }
            }
        }

        int ret = -1;
        int finalMask = (1 << buttonSize) - 1;
        for (int i = 0; i < buttonSize; i++) {
            if (ret == -1 || ret > dp[finalMask][i] + button2SpecialPosMinLen[i][buttonSize + 1]) {
                ret = dp[finalMask][i] + button2SpecialPosMinLen[i][buttonSize + 1];
            }
        }

        return ret;

    }

    public int[][] bfs(int x, int y, String[] maze) {
        int[][] ret = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ret[i], -1);
        }
        ret[x][y] = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int curx = p[0], cury = p[1];
            for (int k = 0; k < 4; k++) {
                int nx = curx + dx[k], ny = cury + dy[k];
                if (inBound(nx, ny) && maze[nx].charAt(ny) != '#' && ret[nx][ny] == -1) {
                    ret[nx][ny] = ret[curx][cury] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return ret;
    }

    public boolean inBound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
