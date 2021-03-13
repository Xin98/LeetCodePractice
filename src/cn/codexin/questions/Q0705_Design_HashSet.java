package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/3/13
 */

public class Q0705_Design_HashSet {
    class MyHashSet {
        private final int BASE = 857;
        private List[] data;
        /** Initialize your data structure here. */
        public MyHashSet() {
            data = new LinkedList[BASE];
            for(int i = 0; i < BASE; i++) {
                data[i] = new LinkedList<Integer>();
            }
        }

        public void add(int key) {
            int idx = key % BASE;
            for(Object num : data[idx]) {
                if((int)num == key) {
                    return;
                }
            }
            data[idx].add(key);
        }

        public void remove(int key) {
            int idx = key % BASE;
            int n = data[idx].size();
            for(int i = 0; i < n; i++) {
                if((int)data[idx].get(i) == key) {
                    data[idx].remove(i);
                    return;
                }
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int idx = key % BASE;
            for(Object num : data[idx]) {
                if((int)num == key) {
                    return true;
                }
            }
            return false;
        }
    }
}
