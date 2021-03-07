package cn.codexin.questions;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xinGao 2021/3/7
 */

public class Q0131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        int n = s.length();
        if(n == 1) {
            ans.add(Arrays.asList(s).stream().collect(Collectors.toList()));
            return ans;
        }
        for (int i = n - 1; i >= 0; i--) {
            String str = s.substring(i);
            if(isPalindrome(str)) {
                List<List<String>> tmp = partition(s.substring(0, i));
                int m = tmp.size();
                if(m == 0) {
                    tmp.add(Arrays.asList(str).stream().collect(Collectors.toList()));
                }
                for (int j = 0; j < m; j++) {
                    tmp.get(j).add(str);
                }
                ans.addAll(tmp);
            }
        }
        return ans;


    }
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
}
