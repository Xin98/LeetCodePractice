package cn.codexin.questions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by xinGao 2020/12/14
 */

public class Q0049_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] freq = new int[26];
            for(int c : str.toCharArray()) {
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                if(freq[i] != 0) {
                    sb.append((char)('a' + i));
                    sb.append(freq[i]);
                }
            }
            String key = sb.toString();
            if(map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> tmp = new LinkedList<>();
                tmp.add(str);
                map.put(key, tmp);
                ans.add(tmp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q0049_Group_Anagrams Q = new Q0049_Group_Anagrams();
        Q.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat","aab","aba"});
    }
}
