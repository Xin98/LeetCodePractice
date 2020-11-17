package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/11/17
 */

public class Q1030_Matrix_Cells_in_Distance_Order {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]>[] bucket = new List[R + C];
        for(int i = 0; i < R + C; i++) {
            bucket[i] = new LinkedList<>();
        }
        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bucket[dist(i, j, r0, c0)].add(new int[]{i, j});
            }
        }
        List<int[]> ans = new LinkedList<>();
        for(int i = 0; i < R + C; i++) {
            ans.addAll(bucket[i]);
        }
        return ans.toArray(new int[][]{});
    }
    public int dist(int i, int j, int r0, int c0) {
        return Math.abs(r0 - i) + Math.abs(c0 - j);
    }
}
