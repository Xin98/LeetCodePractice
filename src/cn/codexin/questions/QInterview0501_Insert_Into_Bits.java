package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/8
 */

public class QInterview0501_Insert_Into_Bits {
    public int insertBits(int N, int M, int i, int j) {
        //清零N的i-j位
        //直接用1<<j+1 在j = 31时会出问题
        N &= ~((1<<j<<1) - (1<<i));
        return N | (M << i);
    }

}
