package cn.codexin.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinGao 2021/1/22
 */

public class Q0989_Add_to_Array_Form_of_Integer {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>();
        int counter = 0;
        int n = A.length;
        int i = n - 1;
        while(i >= 0 || K > 0 || counter > 0) {
            int res = (i >= 0? A[i--]: 0) + K % 10 + counter;
            counter = res / 10;
            res %= 10;
            K /= 10;
            ans.add(0, res);
        }
        return ans;
    }
}
