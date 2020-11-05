package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/11/5
 */

public class Q0127_Word_Ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Set<String> wordSet = new HashSet<>();
        for(String word: wordList) {
            wordSet.add(word);
        }
        Queue<String> q = new LinkedList<>();
        int depth = 0;
        q.offer(beginWord);
        while(!q.isEmpty()) {
            int n = q.size();
            depth++;
            while(n-- > 0) {
                String cur = q.poll();
                for(int i = 0; i < len; i++) {
                    for(int j = 0; j < 26; j++) {
                        String newStr = cur.substring(0, i) + (char)('a' + j) + cur.substring(i + 1, len);
                        if(!wordSet.contains(newStr)) {
                            continue;
                        }
                        if(newStr.equals(endWord)) {
                            return depth + 1;
                        }
                        wordSet.remove(newStr);
                        q.offer(newStr);
                    }
                }
            }
        }
        return 0;
    }
}
