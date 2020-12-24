package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/24
 */

public class Q0135_Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int dec = 0, inc = 1, pre = 1, ans = 1;
        for(int i = 1; i < n; i++) {
            if(ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ans += pre;
                inc = pre;
            } else {
                dec++;
                if(inc == dec) {
                    dec++;
                }
                ans += dec;
                pre = 1;
            }
        }
        return ans;
    }
}
