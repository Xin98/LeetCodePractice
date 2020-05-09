package cn.codexin.questions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xinGao 2020/5/9
 */

public class Q0670_Maximum_Swap {
    public int maximumSwap(int num) {
        // num转化为char数组后，然后排序，再找排序后字符序列与原字符序列第一处不同处，该处就为需要交换处。
        char[] chars = String.valueOf(num).toCharArray();
        char[] sortChars = String.valueOf(num).toCharArray();
        int len = chars.length;
        //last 需要保存 0 ~ 9 数字出现的最后的下标
        //因为交换 数字时， 大的数字最后出现的位置才是需要交换的位置，否则交换后不是最大的。
        int[] last = new int[10];
        for (int i = 0; i < len; i++) {
            int key = chars[i] - '0';
            last[key] = i;
        }
        //这里是升序排序，所以访问排序后的字符序列时需要从后往前访问
        Arrays.sort(sortChars);
        int i = 0, j = len;
        for (; i < len; i++) {
            if (sortChars[len - 1 - i] != chars[i]) {
                j = last[sortChars[len - 1 - i] - '0'];
                break;
            }
        }
        if(i == j) return num;
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return Integer.valueOf(String.valueOf(chars));
    }
}
