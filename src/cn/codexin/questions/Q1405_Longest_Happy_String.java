package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/5/9
 */

public class Q1405_Longest_Happy_String {

    public String longestDiverseString(int a, int b, int c) {
        // 求最小值的原因就是为了保证每个字母的剩余数量都能够加入到结果字符串中。
        MyData[] myData = new MyData[]{new MyData('a', Math.min(a, 2 * (b + c + 1))),
                new MyData('b', Math.min(b, 2 * (a + c + 1))),
                new MyData('c', Math.min(c, 2 * (a + b + 1)))};
        StringBuilder ans = new StringBuilder();
        for (; ; ) {
            //每次选出一个数量最多的或者次多的（最后两个字符想等并等于当前最多的字符，此时就要选第二多的）加入结果字符串中。
            Arrays.sort(myData);
            if (myData[0].value == 0) break;
            if (ans.length() >= 2 &&
                    ans.charAt(ans.length() - 1) == myData[0].key &&
                    ans.charAt(ans.length() - 2) == myData[0].key) {
                ans.append(myData[1].key);
                myData[1].value--;
            } else {
                ans.append(myData[0].key);
                myData[0].value--;
            }
        }
        return ans.toString();
    }

    class MyData implements Comparable<MyData> {
        private char key;
        private int value;

        public MyData(char key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(MyData o) {
            return o.value - value;
        }
    }

}
