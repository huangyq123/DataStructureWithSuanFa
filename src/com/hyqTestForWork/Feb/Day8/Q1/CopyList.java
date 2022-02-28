package com.hyqTestForWork.Feb.Day8.Q1;

import java.util.*;

/**
 * @ClassName CopyList
 * @Description TODO  138. 复制带随机指针的链表  频度 medium
 * @Author huangyq
 * @Date 2022/2/8 20:10
 * @Version
 **/
public class CopyList {
    //思路——将原链表作为元素建立链表，遍历新建立的链表先创建节点，然后根据random指向节点获取索引信息来赋值random指针；
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }

        int length = 0;
        List<Node> pre = new ArrayList<>();

        Node temp = head;
        while(temp!=null){
            length+=1;
            pre.add(temp);
            temp = temp.next;
        }


        Node[] assist = new Node[length];
        //注意需要开辟新空间才是深拷贝
        for(int i=0;i<length;i++){
            assist[i] = new Node(pre.get(i).val);
        }

        //不能把赋值创建和next、random操作一起操作，因为后续节点没创建时是null，next连接完再创建则无法建立连接——因为存储的是对象，新创建的节点有自己的空间，一开始next指向数组空间，赋值知识改变了引用值；？？
        for(int i = 0;i<length-1;i++){
            assist[i].next = assist[i+1];
            Node random = pre.get(i).random;
            int index = pre.indexOf(random);
            if(index>=0&&index<length) {
                assist[i].random = assist[index];
            }else{
                assist[i].random = null;
            }
        }

        assist[length-1].next=null;
        int i = pre.indexOf(pre.get(length - 1).random);
        if(i>=0&&i<length) {
            assist[length - 1].random = assist[i];
        }else{
            assist[length - 1].random = null;
        }

        return assist[0];

    }

    //TODO  递归回溯+哈希表 2.9
    public Node copyRandomList3(Node head){
        if(head==null){
            return head;
        }
        Map<Node,Node> memory = new HashMap<>();
        Node result = dfs(head,memory);
        return result;
    }

    public Node dfs(Node head,Map<Node,Node> memory){

        if(head==null){
            return null;
        }
        if(memory.containsKey(head)){
            return memory.get(head);
        }
        Node temp = new Node(head.val);
        memory.put(head,temp);
        temp.next = dfs(head.next,memory);
        temp.random = dfs(head.random,memory);

        return temp;
    }

    //TODO  迭代+节点拆分 2.9
    public Node copyRandomList2(Node head){

        Node current = head;
        while(current!=null){
            Node temp = new Node(current.val);
            Node next = current.next;
            current.next = temp;
            temp.next = next;
            current = next;
        }

        current = head;
        while(current!=null){
            Node random = current.random;
            if(random!=null) {
                current.next.random = random.next;
            }
            current = current.next.next;
        }

        current = head;
        Node result = current.next;
//        Node resultCurrent = null;
        while(current!=null){
            Node temp = current.next;
            current.next = current.next.next;
            if(temp.next!=null) {
                temp.next = temp.next.next;
            }
            current = current.next;
        }


        return result;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
