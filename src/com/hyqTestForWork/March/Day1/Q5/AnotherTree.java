package com.hyqTestForWork.March.Day1.Q5;

/**
 * @ClassName AnotherTree
 * @Description TODO  572. 另一棵树的子树  easy
 * @Author huangyq
 * @Date 2022/3/1 22:47
 * @Version
 **/
public class AnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean result = false;
        result = dfs(root,subRoot);

        return result;
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }

        //可以使用短路或简化
        boolean b = compareTree(root, subRoot);
        if(b){
            return true;
        }

        boolean dfs = dfs(root.left, subRoot);
        if(dfs){
            return true;
        }
        boolean dfs1 = dfs(root.right, subRoot);
        if(dfs1){
            return true;
        }
        return false;
    }

    private boolean compareTree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(subRoot==null){
            return false;
        }

        if(root.val!= subRoot.val){
            return false;
        }

        return compareTree(root.left,subRoot.left)&&compareTree(root.right,subRoot.right);
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
