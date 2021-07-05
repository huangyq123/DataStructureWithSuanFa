package com.hyq.leetcode.Tree.question2;

import java.util.Stack;

/**
 * @ClassName TreeToLinkList
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/25 19:46
 * @Version
 **/
public class TreeToLinkList {

    public void flatten(TreeNode root) {
        Stack<TreeNode> temp = new Stack<>();
        Recur(root,temp);
    }

    //栈实现，存储下一个右节点，后进先出
    public static void Recur(TreeNode currentNode, Stack<TreeNode> memory){
        if(currentNode==null)
            return ;
        if(currentNode.left==null&&currentNode.right==null&&memory.isEmpty())
            return ;

        if(currentNode.left!=null){
            if(currentNode.right!=null)
                memory.push(currentNode.right);
            currentNode.right = currentNode.left;
            currentNode.left=null;
        }
        else if(currentNode.left==null&&currentNode.right==null)
            currentNode.right = memory.pop();

        Recur(currentNode.right,memory);

    }




    //递归实现
    public static void Recur2(TreeNode root){
        if(root == null)
            return ;

        Recur2(root.left);
        Recur2(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        while(root.right!=null)
            root = root.right;
        root.right = temp;

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
