package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/22
 */

public class Q0706_Design_HashMap {
    //拉链法
    public class MyHashMap {
        /** Initialize your data structure here. */
        class Node{
            private int key;
            private int value;
            private Node next;
            public Node(int key, int value, Node next){
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }
        private Node[] table;
        public MyHashMap() {
            table = new Node[10001];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int idx = key % 10001;
            Node node;
            if(table[idx] == null){
                node = new Node(key, value, null);
            }
            else{
                for(Node next = table[idx]; next != null;next = next.next){
                    if(next.key == key){
                        next.value = value;
                        return;
                    }
                }
                node = new Node(key, value, table[idx]);
            }
            table[idx] = node;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int idx = key % 10001;
            Node node = table[idx];
            for(;;){
                if(node == null) return -1;
                if(node.key == key) return node.value;
                node = node.next;
            }
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int idx = key % 10001;
            Node next = table[idx], pre = next;
            for(;;){
                if(next == null) return;
                if(next.key == key) {
                    if(pre == next) table[idx] = next.next;
                    else pre.next = next.next;
                    return;
                }
                pre = next;
                next = next.next;
            }
        }
    }

    //线性探测法
//    class MyHashMap {
//        /** Initialize your data structure here. */
//        class Node{
//            private int key;
//            private int value;
//            public Node(int key, int value){
//                this.key = key;
//                this.value = value;
//            }
//        }
//        private Node[] table;
//        public MyHashMap() {
//            table = new Node[10001];
//        }
//
//        /** value will always be non-negative. */
//        public void put(int key, int value) {
//            int idx = key % 10001;
//            for(;;){
//                //线性探测解决冲突
//                if(table[idx] == null || table[idx].key == -1) {
//                    table[idx] = new Node(key, value);
//                    return;
//                }
//                else{
//                    Node node = table[idx];
//                    if(node.key == key) {
//                        node.value = value;
//                        return;
//                    }
//                }
//                idx++;
//                idx = idx % 10001;
//            }
//        }
//
//        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//        public int get(int key) {
//            int idx = key % 10001;
//            for(;;){
//                if(table[idx] == null || table[idx].key == -1) return -1;
//                Node node = table[idx];
//                if(node.key == key) return node.value;
//                idx++;
//                idx = idx % 10001;
//            }
//        }
//
//        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//        public void remove(int key) {
//            int idx = key % 10001;
//            for(;;){
//                if(table[idx] == null || table[idx].key == -1) return;
//                Node node = table[idx];
//                if(node.key == key) {
//                    //直接令值为空会导致后面的值查询不到
//                    node.key = -1;
//                    return;
//                }
//                idx++;
//                idx = idx % 10001;
//            }
//        }
//
//    }


}
