package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/10/14
 */

public class Q1002_Find_Common_Characters {
    public List<String> commonChars(String[] A) {
        int[] charCnt1 = new int[26];
        int[] charCnt2 = new int[26];
        Arrays.fill(charCnt2, Integer.MAX_VALUE);
        for(String str : A) {
            for(char c : str.toCharArray()) {
                charCnt1[c - 'a']++;
            }
            for(int i = 0; i < 26; i++) {
                charCnt2[i] = Math.min(charCnt1[i], charCnt2[i]);
                charCnt1[i] = 0;
            }
        }
        List<String> ans = new LinkedList<>();
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < charCnt2[i]; j++) {
                ans.add(String.valueOf((char)('a' + i)));
            }
        }
        return ans;
    }
}
