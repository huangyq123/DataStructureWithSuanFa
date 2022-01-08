package com.hyqTestForWork.Janu.Day5.Q5;


/**
 * @ClassName MaxSubArraySum
 * @Description TODO  236 二叉树最近公共祖先  hot100  medium
 * @Author huangyq
 * @Date 2022/1/4 20:21
 * @Version
 **/
public class LowestAncestor {

    //写的有问题，需要再写一遍
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = null;

        TreeNode leftResult=null;
        if(root.left!=null) {leftResult=lowestCommonAncestor(root.left,p,q);}
        TreeNode rightResult=null;
        if(root.right!=null) {rightResult=lowestCommonAncestor(root.right,p,q);}

        if(leftResult==null&&rightResult==null){
            return result;
        }else if(leftResult!=null){
            return leftResult;
        }else {
            return rightResult;
        }

    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
