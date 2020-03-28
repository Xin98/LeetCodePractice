package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/3/28
 */
public class Q0820_Short_Encoding_of_Words {
    public int minimumLengthEncoding(String[] words) {
        Trim trim = new Trim();
        int res = 0;
        //单词长度长的放在前面
        Arrays.sort(words,(a, b)-> b.length() - a.length());
        for(String word : words){
            res +=trim.insert(word);
        }
        return res;
    }
}
class Trim {
    Node root;

    public Trim() {
        root = new Node();
    }

    //返回每次插入单词的长度
    //倒序插入单词，实现后缀树
    public int insert(String word) {
        boolean isNew = false;
        Node cur = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.node[c] == null) {
                isNew = true;
                cur.node[c] = new Node();
            }
            cur = cur.node[c];
        }
        //是新单词就长度+1(word和#)，否则就可用前面的单词表示，不增加长度
        return isNew ? word.length() + 1 : 0;
    }
}
class Node {
    Node[] node = new Node[27];
    public Node() {
    }
}
