package com.hyqTestForWork.March.Day2.Q3;
/**
 *@Author admin
 *@Description TODO 剑指 Offer 27. 二叉树的镜像  easy
 *@Date 2022/3/2 19:10
 *@Param
 *@return
 *@Version
 **/
public class MirrorsOfBTree {
    //经典递归
    public TreeNode mirrorTree(TreeNode root) {

        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if(root==null){
            return ;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        dfs(root.left);
        dfs(root.right);
    }


    //TODO  栈\队列实现
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
