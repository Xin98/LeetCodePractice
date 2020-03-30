package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xinGao 2020/3/30
 */

public class QInterview0062_Last_Circle_of_Figure {
    //约瑟夫环
    public int lastRemaining(int n, int m) {
        int idx = 0;
        for(int i = 2; i <= n; i++){
            idx = (idx + m) % i;
        }
        return idx;
    }
}
