package com.hyq.day13;

import javax.swing.*;
import javax.swing.tree.TreeNode;

/**
 * @ClassName DeepthOfBinaryTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/11 20:04
 * @Version
 **/
public class DeepthOfBinaryTree {

    static int depth = 0;
    static int count = 0;
    public static int maxDepth(TreeNode3 root){
        if(root==null)
            return 0;

        SearchDepth(root);
        return depth;
    }

    public static void SearchDepth(TreeNode3 root){
        if(root==null){
            depth = Math.max(depth,count);
            return ;
        }

        count++;
        SearchDepth(root.left);
        SearchDepth(root.right);
        count--;
    }
}


 class TreeNode3 {
      int val;
      TreeNode3 left;
      TreeNode3 right;
      TreeNode3(int x) { val = x; }
  }
