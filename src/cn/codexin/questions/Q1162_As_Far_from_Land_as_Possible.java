package cn.codexin.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xinGao 2020/3/29
 */

public class Q1162_As_Far_from_Land_as_Possible {
    /*
    * 思路：
    * 从所有陆地出发，找到最远的海洋。
    * 这样做的好处就是就可以一次性将陆地全部入队列，可以实现同时搜索
    * */
    public int maxDistance(int[][] grid) {
        int nSize = grid.length, dis = -1, qSize = 0;
        int[][]  dirs= {{1, 0},{0, 1},{0, -1},{-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for(int r = 0; r < nSize; r++){
            for(int c = 0; c < nSize; c++){
                if(grid[r][c] == 1){
                    //将所有的陆地入队列
                    queue.offer(new int[]{r, c});
                }
            }
        }
        //如果全为陆地，则返回-1
        if(queue.size() / nSize == nSize) return -1;
        while(!queue.isEmpty()){
            //用dis来记录bfs深度，最后得到的深度就是陆地到最远海洋的距离
            dis++;
            qSize = queue.size();
            while(qSize-- > 0){
                int[] cd = queue.poll();
                for (int[] dir : dirs) {
                    int newR = cd[0] + dir[0], newC = cd[1] + dir[1];
                    if(newR >= nSize || newR < 0 || newC >= nSize || newC < 0) continue;
                    if(grid[newR][newC] == 1) continue;
                    grid[newR][newC] = 1;
                    //当且仅当该区域是海洋的时候才会入队列
                    queue.offer(new int[]{newR, newC});
                }
            }
        }
        return dis;
    }
}
