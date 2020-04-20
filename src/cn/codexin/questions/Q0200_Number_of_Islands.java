package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/20
 */

public class Q0200_Number_of_Islands {
    //并查集
    private int[] parent;
    private int[] dx;
    private int[] dy;
    private int ans;
    public void init(int m, int n){
        parent = new int[m*n];
        for(int i = 0; i < m * n; i++){
            parent[i] = i;
        }
        dx = new int[]{-1, 0};
        dy = new int[]{0, -1};
        ans = 0;
    }
    public int search(int x){
        if(parent[x] != x) //路径压缩
            parent[x] = search(parent[x]);
        return parent[x];
    }
    public void join(int x, int y){// 合并x, y的 parent
        int px = search(x);
        int py = search(y);
        if(px != py) {
            parent[py] = px;
            //陆地合并一块就少一块
            ans--;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        init(m, n);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '0') continue;
                //若当前是陆地 则去寻找周围有没有相邻的陆地
                ans++;
                for(int k = 0; k < 2; k++){
                    int nx = i + dx[k], ny = j + dy[k];
                    //只用向上或者向左搜索即可
                    if(nx < 0 || ny < 0 || grid[nx][ny] == '0') continue;
                    //搜索到未合并过的陆地 并合并
                    join(i*n+j, nx*n+ny);
                }
            }
        }
        return ans;
    }
}
