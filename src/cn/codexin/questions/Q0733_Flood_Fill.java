package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/16
 */

public class Q0733_Flood_Fill {
    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};
    private int borderX;
    private int borderY;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        borderX = image.length;
        if (borderX == 0) {
            return image;
        }
        borderY = image[0].length;
        if(image[sr][sc] != newColor) {
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= borderX || y < 0 || y >= borderY) {
            return;
        }
        if (image[x][y] != oldColor) {
            return;
        }
        image[x][y] = newColor;
        for (int i = 0; i < 4; i++) {
            dfs(image, x + dx[i], y + dy[i], oldColor, newColor);
        }
    }
}
