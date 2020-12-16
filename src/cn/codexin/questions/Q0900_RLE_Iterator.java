package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/16
 */

public class Q0900_RLE_Iterator {
    class RLEIterator {
        private int[] A;
        private int cur;
        private int len;
        public RLEIterator(int[] A) {
            this.A = A;
            cur = 0;
            len = A.length / 2;
        }

        public int next(int n) {
            while(n > 0) {
                if(cur >= len) {
                    break;
                }
                int restCnt = A[2 * cur];
                if(restCnt < n) {
                    cur++;
                    n -= restCnt;
                } else {
                    A[2 * cur] -= n;
                    return A[2 * cur + 1];
                }
            }
            return -1;
        }
    }
}
