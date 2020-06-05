package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/5
 */

public class QInterview0029_Print_Matrix_Clockwise {
    private int[] dx = new int[]{1, 0, -1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;

        int m = matrix[0].length;
        int[] ans = new int[n * m];
        int x = -1;
        int y = -1;
        int idx = 0;
        int C = (Math.min(n, m) + 1) / 2;
        for(int c = 0; c < C; c++){
            x++;
            y++;
            ans[idx++] = matrix[y][x];
            for(int i = 0; i < 4; i++) {
                while(true) {
                    x += dx[i];
                    y += dy[i];
                    if(x < c || x >= m - c || y < c || y >= n - c) {
                        x -= dx[i];
                        y -= dy[i];
                        break;
                    }
                    if(idx == n * m)
                        return ans;
                    ans[idx++] = matrix[y][x];
                }
            }
            idx--;
        }
        return ans;
    }

    public static void main(String[] args) {
        QInterview0029_Print_Matrix_Clockwise Q = new QInterview0029_Print_Matrix_Clockwise();
        Q.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        /**
         * 1 2 3
         * 4 5 6
         * 7 8 9
         */
    }
}
