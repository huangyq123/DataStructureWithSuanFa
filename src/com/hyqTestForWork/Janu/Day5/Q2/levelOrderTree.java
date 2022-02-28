package com.hyqTestForWork.Janu.Day5.Q2;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName MaxSubArraySum
 * @Description TODO  102 层序遍历二叉树  hot100  medium
 * @Author huangyq
 * @Date 2022/1/4 20:21
 * @Version
 **/
public class levelOrderTree {

    /**
     *@Author admin
     *@Description TODO    BFS解决层序遍历
     *@Date 2022/1/5 10:30
     *@Param
     *@return
     *@Version
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLength=1;
        int nextLevelLength=0;
        List<List<Integer>> result = new ArrayList<>();

        while(!queue.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            while(currentLength>0){
                TreeNode temp = queue.poll();
                tempList.add(temp.val);
                if(temp.left!=null) {queue.add(temp.left); nextLevelLength+=1;}
                if(temp.right!=null){queue.add(temp.right); nextLevelLength+=1;}
                currentLength-=1;
            }
            result.add(tempList);
            currentLength=nextLevelLength;
            nextLevelLength=0;
        }

        return result;
    }


    //其他层序遍历变型，以及BFS应用、DFS应用(题解中有总结)

    //dfs实现
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
