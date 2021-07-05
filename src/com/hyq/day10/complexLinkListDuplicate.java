package com.hyq.day10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @ClassName complexLinkListDuplicate
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/8 7:53
 * @Version
 **/
public class complexLinkListDuplicate {
     //思路一
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        //按顺序建立链表
        Node newHead = new Node(head.val);
        Node currentNode = head.next;
        Node newCurrentNode = newHead ;
        while(currentNode!=null){
            newCurrentNode.next = new Node(currentNode.val);
            newCurrentNode = newCurrentNode.next;
            currentNode = currentNode.next;
        }
        //处理随机指针
        newCurrentNode = newHead;
        currentNode = head;
        while(newCurrentNode!=null){     //所有节点处理完毕
            Node target = currentNode.random;      //原链表中的随即指针指向节点
            Node point = head;               //查找指针
            int count = 0;
            while(point!=target){
                point = point.next;
                count++;                       //步数统计
            }
            point = newHead;
            for(int i = count;i>0;i--){            //在新链表中找对应节点
                point = point.next;
            }
            newCurrentNode.random=point;            //连接当前节点的随机指针
            newCurrentNode=newCurrentNode.next;     //开始处理下一个节点
            currentNode = currentNode.next;
        }

        return newHead;
    }

    //思路二
    //问题：哈希表的实现？
    public Node copyRandomList2(Node head){
        if(head == null)
            return null;

        //按顺序建立链表，并建立哈希表
        Node newHead = new Node(head.val);
        Node currentNode = head;
        Node newCurrentNode = newHead ;
         //建立HashMap
        HashMap<Node,Node> memory = new HashMap<>();
        memory.put(currentNode,newCurrentNode);

        while(currentNode.next!=null){
            newCurrentNode.next = new Node(currentNode.next.val);
            newCurrentNode = newCurrentNode.next;
            currentNode = currentNode.next;
            memory.put(currentNode,newCurrentNode);   //存放键值对
        }

        //利用HashMap处理随机指针
        currentNode = head;
        newCurrentNode = newHead ;
        while(currentNode!=null){
            newCurrentNode.random = memory.get(currentNode.random);
            currentNode = currentNode.next;
            newCurrentNode = newCurrentNode.next;
        }

        return newHead;
    }

    //思路三
    public Node copyRandomList3(Node head){
        if(head == null)
            return null;

        Node currentNode = head;
        while(currentNode!=null){      //建立新链表（旧节点、新节点顺序）
            Node point = currentNode.next;             //保存指向
            currentNode.next=new Node(currentNode.val);       //新节点
            currentNode.next.next=point;             //连接新节点
            currentNode = point;
        }

        currentNode =head;
        while(currentNode!=null){            //建立好新链表中新节点的random
            Node point = currentNode.next;
            if(currentNode.random!=null) point.random = currentNode.random.next;
            currentNode = point.next;
        }

        currentNode = head;
        Node newHead = currentNode.next;
        while(currentNode!=null){                   //拆分链表
            Node point = currentNode.next;
            currentNode.next = point.next;
            if(point.next!=null)   point.next = point.next.next;
            currentNode = currentNode.next;
        }
        return newHead;
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