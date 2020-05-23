package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/23
 */

public class Q0076_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        //freq hash
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];

        //compute tFreq
        for (char ct : charArrayT) {
            tFreq[ct]++;
        }

        int sLen = s.length();
        int tLen = t.length();

        int left = 0, right = 0;
        // verify if current window contains all of chars in String 't' by check distance == tLen.
        int distance = 0;
        int minLen = sLen + 1, begin = 0;
        //[left, right)
        while(right < sLen) {
            char rchar = charArrayS[right];
            if(tFreq[rchar] == 0) {
                right++;
                continue;
            }
            if(winFreq[rchar] < tFreq[rchar]) {
                distance++;
            }
            right++;
            winFreq[rchar]++;
            while (distance == tLen) {
                char lchar = charArrayS[left];
                if(tFreq[lchar] == 0) {
                    left++;
                    continue;
                }
                if(winFreq[lchar] == tFreq[lchar]) {
                    if(right - left < minLen) {
                        minLen = right - left;
                        begin = left;
                    }
                    distance--;
                }
                winFreq[lchar]--;
                left++;
            }
        }
        if(minLen == sLen + 1) return "";
        return s.substring(begin, begin + minLen);
    }
}
