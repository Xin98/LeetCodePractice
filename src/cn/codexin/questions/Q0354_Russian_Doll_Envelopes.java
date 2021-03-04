package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/3/4
 */

public class Q0354_Russian_Doll_Envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int en = envelopes.length;
        if(en == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) ->(a[0] == b[0]? b[1] - a[1]: a[0] - b[0]));
        List<Integer> f = new LinkedList<>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < en; i++) {
            int num = envelopes[i][1];
            if(num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int idx = binarySearch(f, num);
                f.set(idx, num);
            }
        }
        return f.size();
    }
    public int binarySearch(List<Integer> f, int num){
        int lo = 0, hi = f.size() - 1;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if(f.get(mid) >= num) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
