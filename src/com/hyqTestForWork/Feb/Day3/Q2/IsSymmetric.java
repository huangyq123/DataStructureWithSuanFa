package com.hyqTestForWork.Feb.Day3.Q2;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName IsSymmetric
 * @Description TODO 101. 对称二叉树 频度 easy
 * @Author huangyq
 * @Date 2022/2/3 20:54
 * @Version
 **/
public class IsSymmetric {

    //总结：递归和迭代地选择问题？？  递归有返回值时处理问题？？

    //递归判断——不会写了，需要复习
    //理解——树的题目考虑：递归、迭代；  递归——考虑递归函数的作用、返回值  迭代——考虑迭代的出入栈顺序
    //这个题的难点——理清楚判断规则，递归函数的作用
    //TODO  2.4
    public boolean isSymmetric(TreeNode root){

        boolean dfs = dfs(root.left, root.right);
        return dfs;
    }

    public boolean dfs(TreeNode root1,TreeNode root2){

        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }

        if(root1.val== root1.val) {
            boolean dfs1 = dfs(root1.left, root2.right);
            if (!dfs1) {
                return false;
            }
            boolean dfs2 = dfs(root1.right, root2.left);
            if (!dfs2) {
                return false;
            }
        }else{
            return false;
        }

        return true ;
    }


    //TODO 迭代2.5
    //递归迭代的转换方式？？
    public boolean isSymmetric3(TreeNode root){

        return false;
    }

    //两次遍历判断
    //bug——当子数中出现多个重复值会导致错误
    public boolean isSymmetric2(TreeNode root){
        Queue<Integer> memoryLeftDfs = new LinkedList<>();
        leftDfs(root,memoryLeftDfs);

        Queue<Integer> memoryRightDfs = new LinkedList<>();
        rightDfs(root,memoryRightDfs);
        while(!memoryLeftDfs.isEmpty()){
            int poll = memoryLeftDfs.poll();
            int poll1 = memoryRightDfs.poll();
            if(poll!=poll1){
                return false;
            }
        }

        return true;
    }

    public void leftDfs(TreeNode root,Queue<Integer> memoryLeftDfs){

        if(root==null){
            return ;
        }

        leftDfs(root.left,memoryLeftDfs);
        memoryLeftDfs.add(root.val);
        leftDfs(root.right,memoryLeftDfs);
    }

    public void rightDfs(TreeNode root,Queue<Integer> memoryLeftDfs){

        if(root==null){
            return ;
        }

        rightDfs(root.right,memoryLeftDfs);
        memoryLeftDfs.add(root.val);
        rightDfs(root.left,memoryLeftDfs);
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
