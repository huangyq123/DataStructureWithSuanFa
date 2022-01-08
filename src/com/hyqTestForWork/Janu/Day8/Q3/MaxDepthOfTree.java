package com.hyqTestForWork.Janu.Day8.Q3;



/**
 * @ClassName MaxDepthOfTree
 * @Description TODO  104  二叉树最大深度 hot100  easy
 * @Author huangyq
 * @Date 2022/1/8 21:04
 * @Version
 **/
public class MaxDepthOfTree {
    //dfs  ——  实现写法可以优化
    public int maxDepth(TreeNode root) {

        int result = dfs(root, 0, 0);
        return result;
    }

    public int dfs(TreeNode root,int depth,int maxDepth){
        if(root==null){
            return depth;
        }

        int temp1=dfs(root.left,depth+1,maxDepth);
        maxDepth=Math.max(maxDepth,temp1);
        int temp2=dfs(root.right,depth+1,maxDepth);
        maxDepth=Math.max(maxDepth,temp2);
        return maxDepth;
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
