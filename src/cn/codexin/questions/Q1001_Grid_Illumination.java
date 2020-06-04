package cn.codexin.questions;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by xinGao 2020/6/4
 */

public class Q1001_Grid_Illumination {
    private final Long MAX_N = 1000000000L;

    private int[] dx = new int[]{1, 1, 1, -1, -1, -1, 0, 0, 0};
    private int[] dy = new int[]{1, 1, 0, 1, -1, 0, 1, -1, 0};

    private HashSet<Long> lampSet = new HashSet<>();
    //行   x ==> key  count ==> value
    private HashMap<Integer, Integer> row = new HashMap<>();
    //列   y ==> key  count ==> value
    private HashMap<Integer, Integer> col = new HashMap<>();
    //左下到右上对角线  x + y ==> key    count ==> value
    private HashMap<Integer, Integer> hillDiag = new HashMap<>();
    //左上到右下对角线 x - y + N - 1 ==> key   count ==> value
    private HashMap<Integer, Integer> downHillDiag = new HashMap<>();

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        for (int[] lamp : lamps) {
            long key = lamp[0] * MAX_N + lamp[1];
            row.put(lamp[0], row.getOrDefault(lamp[0], 0) + 1);
            col.put(lamp[1], col.getOrDefault(lamp[1], 0) + 1);
            hillDiag.put(lamp[0] + lamp[1], hillDiag.getOrDefault(lamp[0] + lamp[1], 0) + 1);
            downHillDiag.put(lamp[0] - lamp[1] + N - 1, downHillDiag.getOrDefault(lamp[0] - lamp[1] + N - 1, 0) + 1);
            lampSet.add(key);
        }

        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int x = query[0];
            int y = query[1];
            //若当前位置无光则说明周围无灯亮，因此可以跳过关灯阶段
            if(!IsLight(x, y, N)) {
                ans[idx++] = 0;
                continue;
            }
            ans[idx++] = 1;
            turnOffAdjLight(x, y, N);
        }
        return ans;
    }

    private void turnOffAdjLight(int x, int y, int N) {
        for(int i = 0; i <= 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
            long key = newX * MAX_N + newY;
            if(lampSet.contains(key)) {
                row.put(newX, row.get(newX) - 1);
                col.put(newY, col.get(newY) - 1);
                hillDiag.put(newX + newY, hillDiag.get(newX + newY) - 1);
                downHillDiag.put(newX - newY + N - 1, downHillDiag.get(newX - newY + N - 1) - 1);
                lampSet.remove(key);
            }
        }
    }

    private boolean IsLight(int x, int y, int N) {
        return row.getOrDefault(x, 0) > 0 ||
                col.getOrDefault(y, 0) > 0 ||
                hillDiag.getOrDefault(x+y, 0) > 0 ||
                downHillDiag.getOrDefault(x-y+ N -1, 0) > 0;
    }

}
