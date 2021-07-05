package com.hyq.leetcode.LRU;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @ClassName LRUCache
 * @Description TODO
 * @Author huangyq
 * @Date 2021/5/10 18:37
 * @Version
 **/
public class LRUCache {

    static class Node {
        public Integer key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    private static HashMap<Integer,Node> position = new LinkedHashMap();
    //private LinkedList<HashMap<Integer,Integer>> cache=new LinkedList<>();
    private static Node head= null;
    private static Node tail=null;
    private static int count = 0;
    private static int length = 0;

    public LRUCache(int capacity) {
        this.length = capacity;
    }

    public static int get(int key) {
        Node node = position.get(key);
        if(node==null)
            return -1;
        if(node==tail){
            return node.val;
        }else if(node==head){
           head=head.next;
           head.prev=null;
           tail.next=node;
        }else{
            node.prev.next = node.next;
            node.next.prev=node.prev;
            tail.next=node;
        }
        node.prev=tail;
        node.next=null;
        tail=tail.next;

        return node.val;
    }

    public static void put(int key, int value) {
        Node temp = new Node(key, value);
        if(position.containsKey(key)){
            position.get(key).val=value;
            get(key);
            return ;
        }

        if(count<length){
            if(head==null){
                head=temp;
                tail=temp;
            }else{
                tail.next=temp;
                tail.next.prev=tail;
                tail=tail.next;

            }
            position.put(key,tail);
            count+=1;
        }else{
            if(head==null)
                return ;
            else{
                tail.next=temp;
                tail.next.prev=tail;
                tail=tail.next;
                position.remove(head.key);
                head.next.prev=null;
                head=head.next;
                position.put(key,tail);
            }
        }
    }


//问题记录：1.思路上，考虑不出到底选用什么数据结构组合来实现
//        2. 没有写清楚处理逻辑就写代码，所以出现细节上的问题

//    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        System.out.println(lRUCache.get(1));    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
//        System.out.println(lRUCache.get(3));    // 返回 3
//        System.out.println(lRUCache.get(4));    // 返回 4
//
//    }
}
