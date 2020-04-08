package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/4/8
 */

public class QInterview0013_Moving_Range_of_Robot {
    //标志数组方法 O（n*m），也可 bfs/dfs
    private int[] parent;
    private int count = 1;
    private int[] dx = {0, 1};
    private int[] dy = {1, 0};
    public int movingCount(int m, int n, int k) {
        parent = new int[m * n];
        parent[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (parent[i * n + j] != 1) continue;
                for (int t = 0; t < 2; t++) {
                    int x = i + dx[t], y = j + dy[t];
                    if (x >= m || y >= n || !canForward(x, y, k)) continue;
                    if (parent[x * n + y] != 1) {
                        count++;
                        parent[x * n + y] = 1;
                    }
                }
            }
        }
        return count;
    }

    boolean canForward(int x, int y, int k) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        ;
        while (y > 0) {
            res += y % 10;
            y /= 10;
        }
        return res <= k;
    }
}
