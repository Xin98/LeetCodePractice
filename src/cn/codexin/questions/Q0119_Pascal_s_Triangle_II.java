package cn.codexin.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xinGao 2021/2/12
 */

public class Q0119_Pascal_s_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        int[] ans = new int[rowIndex + 1];
        Arrays.fill(ans, 1);
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                ans[j] += ans[j-1];
            }
        }
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }
}
