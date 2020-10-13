package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/13
 */

public class Q0795_Number_of_Subarrays_with_Bounded_Maximum {
    private int[] A;
    private int L;
    private int R;
    // 转化一下思维其实就能简化题目 A L R ==> (A 0 R) - (A 0 L-1)
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        this.A = A;
        this.L = L;
        this.R = R;
        int l = 0, n = A.length;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(A[i] > R) {
                cnt += numSubarray(l, i-1);
                l = i + 1;
            }
        }
        cnt += numSubarray(l, n - 1);
        return cnt;
    }
    public int numSubarray(int l, int r) {
        if(l > r) {
            return 0;
        }
        int cnt = 0;
        for(int i = l; i <= r; i++) {
            if(A[i] >= L) {
                cnt += (i - l + 1) * (r - i + 1);
                l = i + 1;
            }
        }
        return cnt;
    }
}
