package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/9
 */

public class Q0069_Sqrt {
    public int mySqrt(int x) {
        //防止hi溢出，因此不能直接用x+1
        int lo = 1, hi = (x - 1) / 2 + 1;
        for (; lo <= hi; ) {
            int mid = lo + (hi - lo) / 2;
            if (x / mid == mid) return mid;
            else if (x / mid < mid) hi = mid - 1;
            else lo = mid + 1;
        }
        return hi;
    }
}
