package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/10/30
 */

public class Q0274_H_Index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 1; i <= n; i++) {
            if(citations[n - i] < i) {
                return i - 1;
            }
        }
        return n;
    }
}
