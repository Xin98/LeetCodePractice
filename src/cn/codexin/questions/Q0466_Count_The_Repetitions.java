package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/4/19
 */

public class Q0466_Count_The_Repetitions {
    //贪心搜索
//    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
//        int len1 = s1.length(), len2 = s2.length(), idx = 0, curN = 0;
//        int ans = 0;
//        int common = gcd(n1, n2);
//        n1 /= common;
//        n2 /= common;
//        for(int i = 0; i < n1; i++){
//            for(int j = 0; j < len1; j++){
//                if(s1.charAt(j) == s2.charAt(idx)){
//                    idx++;
//                    if(idx == len2) {
//                        curN++;
//                        idx = 0;
//                    }
//                    if(curN == n2){
//                        curN = 0;
//                        ans++;
//                    }
//                }
//            }
//        }
//        return ans;
//    }
//    public int gcd(int x, int y){
//        if(y == 0) return x;
//        return gcd(y, x%y);
//    }
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // 循环节算法
        int len1 = s1.length(), len2 = s2.length();
        int ans = 0;
        int idx = 0, s1Count = 0, s2Count = 0;
        int[][] map = new int[len2][];
        //找到循环节之前遍历的s1，s2的次数
        int[] pre = new int[2];
        //保存了s1，s2匹配的循环节的长度
        int[] loop = new int[2];
        while(true){
            s1Count++;
            for(int i = 0; i < len1; i++){
                if(s1.charAt(i) == s2.charAt(idx)){
                    idx++;
                    if(idx == len2){
                        idx = 0;
                        s2Count++;
                    }
                }
            }
            if(s1Count == n1) return s2Count/n2;
            if(map[idx] != null){
                //找到循环节了
                //保存去掉该循环节时的状态
                pre = map[idx];
                //计算循环节的长度
                loop[0] = s1Count - pre[0];
                loop[1] = s2Count - pre[1];
                break;
            }
            else{
                //没找到就添加到哈希表中
                map[idx] = new int[]{s1Count, s2Count};
            }
        }
        //ans 表示 s1中有多少个s2
        ans += pre[1] + (n1 - pre[0]) / loop[0] * loop[1];
        int rest = (n1 - pre[0]) % loop[0];
        for(int i = 0; i < rest; i++){
            for(int j = 0; j < len1; j++){
                if(s1.charAt(j) == s2.charAt(idx)){
                    //idx不能重新开始计数，去掉循环部分后，继续之前已经计数的idx开始计数
                    idx++;
                    if(idx == len2){
                        idx = 0;
                        ans++;
                    }
                }
            }
        }
        return ans / n2;
    }
}
