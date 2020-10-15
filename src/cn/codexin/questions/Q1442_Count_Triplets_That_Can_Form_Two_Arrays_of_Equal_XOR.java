package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/15
 */

public class Q1442_Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        if(n < 2) {
            return 0;
        }
        int cnt = 0;
        for(int i = 0; i < n - 1; i++) {
            int tmp = arr[i];
            for(int j = i + 1; j < n; j++) {
                tmp ^= arr[j];
                if(tmp == 0) {
                    cnt += j - i;
                }
            }
        }
        return cnt;
    }
}
