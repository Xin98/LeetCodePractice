package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/20
 */

public class Q0028_Implement_strStr {
    // KMP
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if(m == 0) {
            return 0;
        }
        int[] prefix = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = prefix[j - 1];
            }
            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            prefix[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = prefix[j - 1];
            }
            if(haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if(j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
