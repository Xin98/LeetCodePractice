package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/9
 */

public class QInterview1713_Re_Space {
    class Tria {
        public Tria[] next;
        public boolean isEnd;

        public Tria() {
            this.next = new Tria[26];
            this.isEnd = false;
        }

        public void insert(String s) {
            Tria cur = this;
            for (int i = s.length() - 1; i >= 0; i--) {
                int idx = s.charAt(i) - 'a';
                if(cur.next[idx] == null) {
                    cur.next[idx] = new Tria();
                }
                cur = cur.next[idx];
            }
            cur.isEnd = true;
        }
    }

    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();
        Tria root = new Tria();
        for (String dict : dictionary) {
            root.insert(dict);
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            Tria cur = root;
            for(int j = i; j >=1; j--) {
                int t = sentence.charAt(j-1) - 'a';
                if(cur.next[t] == null) {
                    break;
                } else if(cur.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if(dp[i] == 0) {
                    break;
                }
                cur = cur.next[t];

            }
        }
        return dp[n];
    }
}
