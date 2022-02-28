package com.hyqTestForWork.Janu.Day24.Q2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName PathSum
 * @Description TODO  113. 路径总和 II  频度 medium
 * @Author huangyq
 * @Date 2022/1/24 20:28
 * @Version
 **/
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum){

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(root,result,temp,targetSum);

        return null;
    }

    public void dfs(TreeNode root, List<List<Integer>> result,List<Integer> temp,int targetSum) {
        if(root==null){
            return ;
        }

        targetSum = targetSum - root.val ;
        if(root.left==null||root.right==null){

           if(targetSum==0){
               temp.add(root.val);
               List<Integer> tempResult = new ArrayList<>();
               for(int i=0;i<temp.size();i++){
                   tempResult.add(temp.get(i));
               }
               result.add(tempResult);
               temp.remove(temp.size()-1);
           }
           return ;
        }

        temp.add(root.val);
        dfs(root.left,result,temp,targetSum);
        dfs(root.right,result,temp,targetSum);
        temp.remove(temp.size()-1);
    }

    //TODO  BFS
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
