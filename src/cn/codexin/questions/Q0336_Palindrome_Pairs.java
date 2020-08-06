package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/8/6
 */

public class Q0336_Palindrome_Pairs {
    List<String> wordRev = new ArrayList<>();
    Map<String, Integer> indices = new HashMap<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for (String word : words) {
            wordRev.add(new StringBuilder(word).reverse().toString());
        }
        for (int i = 0; i < n; i++) {
            indices.put(wordRev.get(i), i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            if(m == 0) {
                continue;
            }
            for (int j = 0; j <= m; j++) {
                if(isPalindrome(word, j, m-1)) {
                    int leftId = findWord(word, 0, j - 1);
                    if(leftId != -1 && leftId != i) {
                        res.add(Arrays.asList(i, leftId));
                    }
                }
                if(j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightId = findWord(word, j, m - 1);
                    if(rightId != -1 && rightId != i) {
                        res.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return res;
    }
    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }
}
