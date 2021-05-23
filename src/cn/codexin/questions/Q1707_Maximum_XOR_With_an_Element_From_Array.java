package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/23
 */

public class Q1707_Maximum_XOR_With_an_Element_From_Array {
    class Trie{
        static final int L = 30;
        Trie[] children = new Trie[2];
        int min = Integer.MAX_VALUE;
        public void insert(int val) {
            Trie node = this;
            node.min = Math.min(val, node.min);
            for (int i = L - 1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if(node.children[bit] == null) {
                    node.children[bit] = new Trie();
                }
                node = node.children[bit];
                node.min = Math.min(node.min, val);
            }
        }
        public int getMaxXorWithLimit(int val, int limit) {
            Trie node = this;
            if(node.min > limit) {
                return -1;
            }
            int ans = 0;
            for (int i = L - 1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if(node.children[bit ^ 1] != null && node.children[bit ^ 1].min <= limit) {
                    ans |= 1 << i;
                    bit ^= 1;
                }
                node = node.children[bit];
            }
            return ans;
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
        }
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = trie.getMaxXorWithLimit(queries[i][0], queries[i][1]);
        }
        return ans;
    }
}
