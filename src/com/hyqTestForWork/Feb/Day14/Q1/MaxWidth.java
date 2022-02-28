package com.hyqTestForWork.Feb.Day14.Q1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MaxWidth
 * @Description TODO 662. 二叉树最大宽度  频度 medium
 * @Author huangyq
 * @Date 2022/2/14 20:28
 * @Version
 **/
public class MaxWidth {
    //BFS 经典实现——一个队列记录节点，一个队列记录位置，  为例便于计算，使用双端队列
    public int widthOfBinaryTree(TreeNode root) {

        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> indexOfNode = new LinkedList<>();

        nodeQueue.addLast(root);
        indexOfNode.addLast(0);
        int resultLength = 1;
        while(!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            resultLength = Math.max(resultLength,indexOfNode.peekLast()-indexOfNode.peekFirst()+1);
            while(size>0){
                TreeNode poll = nodeQueue.pollFirst();
                Integer index = indexOfNode.pollFirst();

                if(poll.left!=null){
                    nodeQueue.addLast(poll.left);
                    indexOfNode.addLast(index*2+1);
                }

                if(poll.right!=null){
                    nodeQueue.addLast(poll.right);
                    indexOfNode.addLast(index*2+2);
                }
                size--;
            }
        }

        return resultLength;
    }

    //TODO  DFS
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
