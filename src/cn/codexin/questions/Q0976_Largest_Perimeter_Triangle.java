package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/11/29
 */

public class Q0976_Largest_Perimeter_Triangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        for(int i = n - 3; i >= 0; i--) {
            if(A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;
    }
}
