package com.hyqTestForWork.Feb.Day10.Q2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName CheckBinaryTree
 * @Description TODO
 * @Author huangyq
 * @Date 2022/2/10 20:59
 * @Version
 **/
public class CheckBinaryTree {
    //思路——BFS遍历所有节点，使用 1 0 记录节点是否为空；  遍历完后从末尾开始查找状态，当出现1之后又出现0，则说明是非完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }

        Deque<Integer> status = new LinkedList<>();
        Queue<TreeNode> memory = new LinkedList<>();
        memory.add(root);

        while(!memory.isEmpty()){
            TreeNode poll = memory.poll();
            if(poll==null){
                status.add(0);
                continue;
            }else{
                status.add(1);
                memory.add(poll.left);
                memory.add(poll.right);
            }
        }

        while(!status.isEmpty()){
            if(status.peekLast()==0){
                status.pollLast();
            }else {
                break;
            }
        }

        boolean flag = true;
        while(!status.isEmpty()){
            if(status.pollLast()==0){
                flag = false;
                break;
            }
        }

        return flag;
    }

    //TODO  一次遍历的BFS
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
