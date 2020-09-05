package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/5
 */

public class Q0060_Permutation_Sequence {

    private int[] factorial;
    private boolean[] used;

    private int n;
    private int k;
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        factorial = new int[n + 1];
        used = new boolean[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1] * i;
        }
        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }
    public void dfs(int idx, StringBuilder path) {
        if(idx == n) {
            return;
        }
        int cnt = factorial[n -1 -idx];
        for (int i = 1; i <= n; i++) {
            if(used[i]) {
                continue;
            }
            if(cnt < k) {
                k -= cnt;
                continue;
            }
            used[i] = true;
            path.append(i);
            dfs(idx + 1, path);
            return;
        }
    }
}
