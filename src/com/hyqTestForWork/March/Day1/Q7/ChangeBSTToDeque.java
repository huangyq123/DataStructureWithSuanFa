package com.hyqTestForWork.March.Day1.Q7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName ChangeBSTToDeque
 * @Description TODO  剑指 Offer 36. 二叉搜索树与双向链表 medium
 * @Author huangyq
 * @Date 2022/3/1 23:15
 * @Version
 **/
public class ChangeBSTToDeque {
    //中序遍历一次，再进行拼接
    public Node treeToDoublyList(Node root) {
        Queue<Node> memory = new LinkedList<>();
        dfs(root,memory);

        Node pre = new Node();
        Node current = pre;

        while(!memory.isEmpty()){
            Node poll = memory.poll();
            poll.left = current;
            current.right = poll;
            current = poll;
        }
        current.right = pre.left;
        pre.left.left = current;
        pre.left = null;

        return current.right;
    }

    private void dfs(Node root, Queue<Node> memory) {
        if(root==null){
            return ;
        }

        dfs(root.left,memory);
        memory.add(root);
        dfs(root.right,memory);

    }


    //TODO  一次遍历并拼接

}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};