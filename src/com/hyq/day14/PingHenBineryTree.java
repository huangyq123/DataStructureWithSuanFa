package com.hyq.day14;

/**
 * @ClassName PingHenBineryTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/12 8:35
 * @Version
 **/
public class PingHenBineryTree {


    public static boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        return Recur(root)>0;

    }

    public static int Recur(TreeNode root){
        if(root==null)
            return 0;


        int lengthOfLeft = Recur(root.left);
        int lengthOfRight = Recur(root.right);

        if(lengthOfLeft<0||lengthOfRight<0)
            return -1;

        if((lengthOfLeft-lengthOfRight)>=-1&&(lengthOfLeft-lengthOfRight)<=1)
            return Math.max(lengthOfLeft,lengthOfRight)+1;
        else
            return -1;
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }