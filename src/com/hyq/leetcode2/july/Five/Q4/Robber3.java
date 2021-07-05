package com.hyq.leetcode2.july.Five.Q4;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Robber3
 * @Description TODO  打家劫舍3  337
 * @Author huangyq
 * @Date 2021/7/5 19:47
 * @Version
 **/
public class Robber3 {

    //问题：写不出来转移方程，不能确定dp的含义
    public int rob(TreeNode root) {
        ArrayList<TreeNode> temp = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            temp.add(poll);
            if(poll!=null){
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }

        int result=0;
        int[] dp = new int[temp.size()];
//        for(int i=temp.size()-1;i>=0;i--){
//            if((i*4+6)<temp.size()){
//
//            }
//        }

        return 0;
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
