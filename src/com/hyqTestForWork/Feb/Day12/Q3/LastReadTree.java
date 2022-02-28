package com.hyqTestForWork.Feb.Day12.Q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName LastReadTree
 * @Description TODO  145. 二叉树的后序遍历  频度 easy
 * @Author huangyq
 * @Date 2022/2/12 17:39
 * @Version
 **/
public class LastReadTree {
    //递归
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        dfs(root,result);

        return result;
    }

    public void dfs(TreeNode root,List<Integer> result){

        if(root==null){
            return ;
        }
        dfs(root.left,result);
        dfs(root.right,result);
        result.add(root.val);
    }


    //  TODO  迭代——如何出栈？？
    // 系统的复习一遍迭代实现三种遍历  以及 规范
    public List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> memory = new Stack<>();
        memory.add(root);
        TreeNode newRoot = root.left;
        while(!memory.isEmpty()){
            while(newRoot!=null){
                memory.push(newRoot);
                newRoot = newRoot.left;
            }
            newRoot = memory.peek().right;
            //这里有问题——怎么pop根节点
            if(newRoot==null){
                TreeNode temp = memory.pop();
                result.add(temp.val);
                newRoot = memory.peek().right;
            }
        }

        return result;
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
