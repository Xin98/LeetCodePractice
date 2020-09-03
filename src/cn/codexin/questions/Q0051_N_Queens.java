package cn.codexin.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xinGao 2020/9/3
 */

public class Q0051_N_Queens {
    private int[] leftUp2RightDown;
    private int[] leftDown2RightUp;
    private int[] left2Right;
    private int[] up2Down;
    private List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        left2Right = new int[n];
        up2Down = new int[n];
        leftUp2RightDown = new int[2 * n - 1];
        leftDown2RightUp = new int[2 * n - 1];
        ans = new ArrayList<>();
        List<String> solve = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dfs(solve, 0, i, n);
        }
        return ans;
    }

    public void dfs(List<String> solve,int x, int y, int n) {
        if(left2Right[x] == 1 || up2Down[y] == 1 || leftUp2RightDown[n - 1 - x + y] == 1 || leftDown2RightUp[x + y] == 1) {
            return;
        }
        left2Right[x] = 1;
        up2Down[y] = 1;
        leftUp2RightDown[n - 1 - x + y] = 1;
        leftDown2RightUp[x + y] = 1;
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        chars[y] = 'Q';
        solve.add(String.valueOf(chars));
        if(x == n - 1) {
            ans.add(new ArrayList<>(solve));
        } else {
            for (int i = 0; i < n; i++) {
                if(i != y) {
                    dfs(solve, x + 1, i, n);
                }
            }
        }
        left2Right[x] = 0;
        up2Down[y] = 0;
        leftUp2RightDown[n - 1 - x + y] = 0;
        leftDown2RightUp[x + y] = 0;
        solve.remove(solve.size() - 1);
    }

    public static void main(String[] args) {
        Q0051_N_Queens Q = new Q0051_N_Queens();
        Q.solveNQueens(4);
    }
}
