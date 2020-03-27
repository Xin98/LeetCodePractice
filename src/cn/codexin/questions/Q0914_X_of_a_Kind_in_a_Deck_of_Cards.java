package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/3/27
 */

public class Q0914_X_of_a_Kind_in_a_Deck_of_Cards {
    //使用map 执行用时15ms 内存42.3MB
/*    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> m = new HashMap<>();
        int gcd = -1;
        for(int card : deck){
            if(!m.containsKey(card)){
                m.put(card, 1);
            }
            else {
                m.put(card, m.get(card) + 1);
            }
        }

        for(int key : m.keySet()){
            if(gcd == -1) {
                gcd = m.get(key);
            }
            else{
                gcd = computeGcd(gcd, m.get(key));
            }
            if(gcd < 2) return false;
        }
        return true;
    }*/
    //题目说deck的值是在 1 - 10000 ,所以我们尝试用数组代替hashmap
    //执行用时5ms 内存消耗41.3MB
    public boolean hasGroupsSizeX(int[] deck) {
        int[] m = new int[10000];
        int gcd = -1;
        for(int card : deck){
            m[card]++;
        }
        for(int i = 0; i < 10000; i++){
            if(m[i] > 0){
                if(gcd == -1) {
                    gcd = m[i];
                }
                else{
                    gcd = computeGcd(gcd, m[i]);
                }
            }
        }
        return gcd >= 2;
    }
    public int computeGcd(int a, int b){
        return b == 0 ? a :computeGcd(b, a%b);
    }
}
