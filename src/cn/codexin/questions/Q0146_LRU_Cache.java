package cn.codexin.questions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/4/1
 */

public class Q0146_LRU_Cache {
    // 不用工具类 自己实现
    class DLinkedNode {
        private int key;
        private int value;
        private DLinkedNode pre;
        private DLinkedNode next;

        public DLinkedNode() {}

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head;
    private DLinkedNode tail;

    private int size;
    private int capacity;

    public Q0146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if(size > capacity) {
                DLinkedNode removeNode = removeLast();
                cache.remove(removeNode.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeLast() {
        DLinkedNode tailNode = tail.pre;
        removeNode(tailNode);
        return tailNode;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);        
    }

    // linkedhashmap
//    private Map<Integer, Integer> data;
//    public Q0146_LRU_Cache(int capacity) {
//        data = new LinkedHashMap<Integer, Integer>((int)(capacity / 0.75f), 0.75f, true){
//            @Override
//            protected boolean removeEldestEntry(Map.Entry eldest) {
//                if(data.size() > capacity) return true;
//                return false;
//            }
//        };
//    }
//    public int get(int key) {
//        int value = data.getOrDefault(key, -1);
//        return value;
//    }
//    public void put(int key, int value) {
//        data.put(key, value);
//    }



    public static void main(String[] args) {
        Q0146_LRU_Cache q146_lru_cache = new Q0146_LRU_Cache(2);
        q146_lru_cache.put(2,1);
        q146_lru_cache.put(1,1);
        q146_lru_cache.put(2,3);
        q146_lru_cache.put(4,1);
        System.out.println(q146_lru_cache.get(1));
        System.out.println(q146_lru_cache.get(2));
    }
}
