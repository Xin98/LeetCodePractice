package cn.codexin.questions;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/6/22
 */

public class QSword_0038_Permutation_of_String {
    public String[] permutation(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        Arrays.sort(str);
        List<String> ans = new LinkedList<>();
        backtrack(str, new boolean[n], new StringBuilder(), ans);
        return ans.stream().toArray(size -> new String[size]);
    }
    private void backtrack(char[] str, boolean[] visited, StringBuilder tmp, List<String> ans) {
        if(tmp.length() == str.length) {
            ans.add(tmp.toString());
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if(visited[i] || i > 0 && str[i] == str[i-1] && !visited[i-1]) {
                continue;
            }
            tmp.append(str[i]);
            visited[i] = true;
            backtrack(str, visited, tmp, ans);
            visited[i] = false;
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
