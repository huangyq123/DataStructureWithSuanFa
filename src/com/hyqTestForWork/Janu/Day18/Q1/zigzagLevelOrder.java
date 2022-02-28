package com.hyqTestForWork.Janu.Day18.Q1;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName zigzagLevelOrder
 * @Description TODO  103 锯齿形遍历二叉树  频度 medium
 * @Author huangyq
 * @Date 2022/1/18 19:40
 * @Version
 **/
public class zigzagLevelOrder {
    //层序遍历，通过使用双端队列来在不同层进行不同方向（头、尾）的入队和出队来实现顺序改变
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> memory = new ArrayDeque<>();

        if(root==null){
            return result;
        }

        memory.push(root);
        int count=1;
        int flag=1;
        while(!memory.isEmpty()){
            count = memory.size();
            if(flag%2!=0) {
                List<Integer> tempList = new ArrayList<>();
                while (count > 0) {
                    TreeNode temp = memory.pollFirst();
                    if (temp.left != null) memory.addLast(temp.left);
                    if (temp.right != null) memory.addLast(temp.right);
                    tempList.add(temp.val);
                    count--;
                }
                result.add(tempList);
            }else{
                List<Integer> tempList = new ArrayList<>();
                while (count > 0) {
                    TreeNode temp = memory.pollLast();
                    if (temp.right != null) memory.addFirst(temp.right);
                    if (temp.left != null) memory.addFirst(temp.left);
                    tempList.add(temp.val);
                    count--;
                }
                result.add(tempList);
            }
            flag+=1;
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
