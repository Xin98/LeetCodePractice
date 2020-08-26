package cn.codexin.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinGao 2020/8/26
 */

public class Q0017_Letter_Combinations_of_a_Phone_Number {
    private String[] mapping = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0) {
            dfs(digits, "", 0, digits.length());
        }
        return ans;
    }
    public void dfs(String digits, String res, int i, int len) {
        if(i == len) {
            ans.add(res);
            return;
        }
        for (char word : mapping[digits.charAt(i) - '2'].toCharArray()) {
            dfs(digits, res + word, i + 1, len);
        }
    }
}
