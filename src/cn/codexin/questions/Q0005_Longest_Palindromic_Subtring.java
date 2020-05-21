package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/21
 */

public class Q0005_Longest_Palindromic_Subtring {
    //2. manacher
    public String longestPalindrome(String s) {
        int start = 0, end = -1;
        s = "#" + insertDelimiterToString(s, "#") + "#";
        int n = s.length();
        int[] armLens = new int[n];
        int right = -1, j = -1;
        for(int i = 0; i < n; i++) {
            int curArmLen = 0;
            if(i >= right) curArmLen = expandAroundCenter(s, i, i);
            else {
                int iSym = 2 * j - i;
                int minArmLen = Math.min(armLens[iSym], right - i);
                curArmLen = expandAroundCenter(s, i - minArmLen, i + minArmLen);
            }
            armLens[i] = curArmLen;
            if(i + curArmLen > right) {
                j = i;
                right = i + curArmLen;
            }
            if(curArmLen * 2 + 1 > end - start) {
                start = i - curArmLen;
                end = i + curArmLen;
            }
        }

        return s.substring(start, end + 1).replaceAll("#","");
    }
    private int expandAroundCenter(String s, int left, int right) {
        int lo = left, hi = right;
        while(lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }
        return (hi - lo - 2) / 2;
    }
    private String insertDelimiterToString(String s, String delimiter) {
        int n = s.length();
        if(n <= 1) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n-1; i++) {
            sb.append(s.charAt(i) + delimiter);
        }
        sb.append(s.charAt(n-1));
        return sb.toString();
    }
    //1. 中心拓展法
//    public String longestPalindrome(String s) {
//        int n = s.length();
//        int start = 0, end = -1;
//        for(int i = 0; i < n; i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if(len > end - start) {
//                start = i - (len-1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    private int expandAroundCenter(String s, int left, int right) {
//        int lo = left, hi = right;
//        while(lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
//            lo--;
//            hi++;
//        }
//        return hi - lo - 1;
//    }
    public static void main(String[] args) {
        Q0005_Longest_Palindromic_Subtring Q = new Q0005_Longest_Palindromic_Subtring();
        Q.longestPalindrome("cbbd");
    }
}
