package com.hyqTestForWork.Janu.Day11.Q2;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;

/**
 * @ClassName LRU
 * @Description TODO  146  LRU缓存机制   频度 2  medium
 * @Author huangyq
 * @Date 2022/1/11 21:07
 * @Version
 **/
public class LRUCache {

    //没想出来用什么数据结构，同时看了题解（结构部分）进行实现时细节上出了一些bug  —— 1.12重写

    private HashMap<Integer,Node> memory = new LinkedHashMap<>();
    private Node head = null;
    private Node tail = null;
    private Integer capacity=0;
    private Integer length=0;

    class Node{
        int val;
        Node next;
        Node pre;
        public Node(){
            this.next=null;
            this.pre=null;
        }
        public Node(int value){
            this.val=value;
            this.next=null;
            this.pre=null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        Node node = memory.get(key);
        if(node==null){
            return -1;
        }
        if(node==head){
            return node.val;
        }
        if(node!=tail){
            node.next.pre=node.pre;
        }else{
            tail=node.pre;
        }
        node.pre.next=node.next;
        node.next=head;
        node.pre=null;
        head.pre=node;
        head=node;
        return node.val;
    }

    public void put(int key, int value) {
        Node node = memory.get(key);
        if(node!=null){
            node.val=value;
            get(key);
        }else{
            Node node1 = new Node();
            node1.val=value;
            node1.next=head;
            node1.pre=null;
            head=node1;
            length+=1;
            if(tail==null){
                tail=node1;
            }

            if(length>capacity){
                Node temp = tail;
                tail = tail.pre;
                tail.next=null;
                temp.pre=null;
                memory.remove(temp.val);
                length-=1;
            }
        }
    }
}
