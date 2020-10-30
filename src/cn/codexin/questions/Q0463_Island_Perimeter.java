package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/10/30
 */

public class Q0463_Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        if(n == 0) {
            return 0;
        }
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    if(i == 0 || grid[i-1][j] == 0) {
                        ans++;
                    }
                    if(i == n - 1 || grid[i + 1][j] == 0) {
                        ans++;
                    }
                    if(j == 0 || grid[i][j-1] == 0) {
                        ans++;
                    }
                    if(j == m - 1 || grid[i][j + 1] == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
