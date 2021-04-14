package cn.codexin.questions;

/**
 * Created by xinGao 2021/4/14
 */

public class Q0208_Implement_Trie_Prefix_Tree {
    class Trie {
        private Trie[] child;
        private boolean end;
        /** Initialize your data structure here. */
        public Trie() {
            child = new Trie[26];
            end = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie node = this;
            for(char c : word.toCharArray()){
                if(node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new Trie();
                }
                node = node.child[c - 'a'];
            }
            node.end = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = this;
            for(char c : word.toCharArray()){
                if(node.child[c - 'a'] == null) {
                    return false;
                }
                node = node.child[c - 'a'];
            }
            return node.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie node = this;
            for(char c : prefix.toCharArray()){
                if(node.child[c - 'a'] == null) {
                    return false;
                }
                node = node.child[c - 'a'];
            }
            return true;
        }
    }
}
