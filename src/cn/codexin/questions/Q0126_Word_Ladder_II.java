package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/6/7
 */

public class Q0126_Word_Ladder_II {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        List<List<String>> ans = new LinkedList<>();
        Queue<List<String>> q1 = new LinkedList<>();
        Queue<List<String>> q2 = new LinkedList<>();

        q1.offer(Arrays.asList(beginWord));
        q2.offer(Arrays.asList(endWord));

        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        Set<String> subVisited = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        Map<String, List<List<String>>> wordConnectMap = new HashMap<>();

        wordSet.addAll(wordList);
        visited1.add(beginWord);
        visited2.add(endWord);
        if(!wordSet.contains(endWord)) return ans;
        boolean isFind = false;

        while (!q1.isEmpty() && !q2.isEmpty() && !isFind) {

            if (q2.size() < q1.size()) {
                Queue<List<String>> tmpQue = q2;
                q2 = q1;
                q1 = tmpQue;
                Set<String> tmpVisit = visited2;
                visited2 = visited1;
                visited1 = tmpVisit;
            }
            int m = q1.size();
            for (int i = 0; i < m; i++) {
                List<String> wordPath = q1.poll();
                char[] wordChar = wordPath.get(wordPath.size() - 1).toCharArray();
                for (int j = 0; j < len; j++) {
                    char tmp = wordChar[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChar[j] = c;
                        String newWord = String.valueOf(wordChar);
                        if (visited1.contains(newWord)) continue;
                        if (visited2.contains(newWord)) {
                            List<List<String>> paths = wordConnectMap.getOrDefault(newWord, new LinkedList<>());
                            paths.add(wordPath);
                            wordConnectMap.putIfAbsent(newWord, paths);
                            isFind = true;
                            continue;
                        }
                        if (wordSet.contains(newWord)) {
                            List<String> path = new LinkedList<>(wordPath);
                            path.add(newWord);
                            q1.offer(path);
                            subVisited.add(newWord);
                        }
                    }
                    wordChar[j] = tmp;
                }
            }
            visited1.addAll(subVisited);
            subVisited.clear();

        }
        while (!q2.isEmpty()) {

            List<String> beginPath = q2.poll();
            String midWord = beginPath.get(beginPath.size() - 1);
            if(wordConnectMap.containsKey(midWord)) {
                List<List<String>> endPaths = wordConnectMap.get(midWord);
                for (List<String> endPath : endPaths) {
                    List<String> res = new LinkedList<>();
                    res.addAll(beginPath);
                    ListIterator<String> it = endPath.listIterator(endPath.size());
                    while (it.hasPrevious()) {
                        String word = it.previous();
                        res.add(word);
                    }
                    if(res.get(0) == endWord) Collections.reverse(res);
                    ans.add(res);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q0126_Word_Ladder_II Q = new Q0126_Word_Ladder_II();
        Q.findLadders("hit", "cog", new LinkedList<>(Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
