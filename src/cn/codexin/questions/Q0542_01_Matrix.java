package cn.codexin.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xinGao 2020/4/15
 */

public class Q0542_01_Matrix {



    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> queue = new LinkedList<>();
        boolean hasOne = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //所有为0的元素入队列
                if(matrix[i][j] == 0)
                    queue.offer(new int[]{i,j});
                else {
                    hasOne = true;
                    matrix[i][j] = -1;
                }
            }
        }
        if(!hasOne) return matrix;
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for(int i = 0; i < 4; i++){
                int xn = x + dx[i];
                int yn = y + dy[i];
                if(xn < 0 || xn >= m || yn < 0 || yn >= n || matrix[xn][yn] != -1) continue;
                matrix[xn][yn] = matrix[x][y] + 1;
                queue.offer(new int[]{xn, yn});
            }
        }
        return matrix;
    }
}
