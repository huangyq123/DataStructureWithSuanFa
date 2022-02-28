package com.hyqTestForWork.Janu.Day23.Q4;



/**
 * @ClassName SumOfTree
 * @Description TODO  129. 求根节点到叶节点数字之和  pindu  medium
 * @Author huangyq
 * @Date 2022/1/23 20:49
 * @Version
 **/
public class SumOfTree {

    private int sum = 0;
    //使用全局变量的递归
    public int sumNumbers(TreeNode root) {

        if(root == null){
            return 0;
        }

        dfs(root,0);

        return sum;
    }

    public void dfs(TreeNode root ,int value){
        if(root==null){
            return ;
        }

        value = value * 10 + root.val;
        if(root.left==null && root.right==null){
            sum = sum + value;
            return ;
        }


        if(root.left!=null) dfs(root.left,value);
        if(root.right!=null) dfs(root.right,value);

        return  ;
    }

    //递归不使用全局变量
    public int sumNumbers2(TreeNode root) {

        if(root == null){
            return 0;
        }



        return dfs2(root,0);
    }

    public int dfs2(TreeNode root ,int value){
        if(root==null){
            return 0;
        }

        value = value * 10 + root.val;
        if(root.left==null && root.right==null){
            return value;
        }


         return dfs2(root.left,value)+dfs2(root.right,value);


    }

    //TODO  BFS实现
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
