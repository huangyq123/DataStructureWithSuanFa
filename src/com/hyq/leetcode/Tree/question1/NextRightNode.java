package com.hyq.leetcode.Tree.question1;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NextRightNode
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/25 19:09
 * @Version
 **/
public class NextRightNode {

    //空间效率低
    public Node2 connect(Node2 root) {
        if(root==null)
            return null;

        Queue<Node2> temp = new LinkedList<>();
        temp.add(root);
        while(!temp.isEmpty()){
            for(int k=temp.size();k>0;k--){
                Node2 now = temp.poll();
                temp.add(now.left);
                temp.add(now.right);
                if(k==1)
                    now.next=null;
                else
                    now.next=temp.peek();
            }
        }
        return root;
    }
}


class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right, Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}