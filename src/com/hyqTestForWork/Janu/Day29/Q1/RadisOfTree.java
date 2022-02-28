package com.hyqTestForWork.Janu.Day29.Q1;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName RadisOfTree
 * @Description TODO 543. 二叉树的直径 频度 easy
 * @Author huangyq
 * @Date 2022/1/29 18:34
 * @Version
 **/
public class RadisOfTree {
    //不会——看了上一次的做题记录
    //  问题——递归函数的作用没有分析清楚：递归函数用于计算当前树的最长直径，遍历一遍可以得到所有树的直径；  直径等于最大深度的差；
     public int diameterOfBinaryTree(TreeNode root) {
         int[] result=new int[]{0};
         depth(root,result);

         return result[0];
     }

     public int depth(TreeNode root,int[] result){
         if(root==null){
             return 0;
         }

         int leftDepth = depth(root.left,result);
         int rightDepth = depth(root.right,result);

         if(leftDepth+rightDepth>result[0]){
             result[0]=leftDepth+rightDepth;
         }
         return Math.max(leftDepth,rightDepth)+1;
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
