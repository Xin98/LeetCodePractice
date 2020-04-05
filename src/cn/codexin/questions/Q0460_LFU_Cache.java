package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/4/5
 */

public class Q0460_LFU_Cache {
    private int curTime= 0;
    private int size = 0;
    private Queue<Node> queue;
    private Map<Integer, Node> data;
    private int capacity;
    public Q0460_LFU_Cache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>();
        if(capacity > 0) {
            queue = new PriorityQueue<Node>(capacity, (a, b)->a.cnt - b.cnt == 0 ? a.time - b.time : a.cnt - b.cnt);
        }
    }
    public int get(int key) {
        Node node = data.get(key);
        if(node == null) return -1;
        node.cnt++;
        node.time = ++curTime;
        afterAccess(node);
        return node.value;
    }
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(!data.containsKey(key)){
            if(size == capacity){
                int removeKey = queue.poll().key;
                data.remove(removeKey);
                size--;
            }
            Node node = new Node(key, value, ++curTime);
            queue.add(node);
            data.put(key, node);
            size++;
        }
        else{
            Node node = data.get(key);
            node.time = ++curTime;
            node.cnt++;
            node.value = value;
            afterAccess(node);
        }
    }
    public void afterAccess(Node node){
        queue.remove(node);
        queue.offer(node);
    }
    class Node{
        private int key;
        private int value;
        private int cnt;
        private int time;
        public Node(int key, int value, int time) {
            this.key = key;
            this.value = value;
            this.time = time;
            cnt = 1;
        }
    }
}

