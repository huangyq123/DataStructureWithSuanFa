package com.hyqTestForWork.Janu.Day9.Q5;

import java.util.Stack;

/**
 * @ClassName ReverseTree
 * @Description TODO 226 翻转二叉树  hot100 easy
 * @Author huangyq
 * @Date 2022/1/9 13:19
 * @Version
 **/
public class ReverseTree {
    //递归实现
    public TreeNode invertTree(TreeNode root) {

        Reverse(root);
        return root;
    }

    public void Reverse(TreeNode root){

        if(root==null){
            return ;
        }

        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;

        Reverse(root.left);
        Reverse(root.right);
    }


    //迭代实现——有点照搬迭代实现，需要深入理解一下迭代实现
    public TreeNode invertTree2(TreeNode root) {
        Stack<TreeNode> memory = new Stack<>();
        TreeNode result = root;
        while(root!=null||!memory.isEmpty()){
            while(root!=null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                memory.push(root);
                root=root.left;
            }
            root = memory.pop();
            root=root.right;
        }

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
