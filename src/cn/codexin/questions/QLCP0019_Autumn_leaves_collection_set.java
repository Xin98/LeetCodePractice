package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/1
 */

public class QLCP0019_Autumn_leaves_collection_set {
    // 状态压缩的dp
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int[] f = new int[3];
        f[0] = (leaves.charAt(0) == 'y')? 1: 0;
        f[1] = f[2] = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            int isRed = (leaves.charAt(i) == 'r')? 1: 0;
            int isYellow = (leaves.charAt(i) == 'y')? 1: 0;
            if(i >= 2) {
                f[2] = Math.min(f[1], f[2]) + isYellow;
            }
            f[1] = Math.min(f[0], f[1]) + isRed;
            f[0] = f[0] + isYellow;
        }
        return f[2];
    }
}
