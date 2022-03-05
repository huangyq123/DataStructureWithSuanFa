package com.hyqTestForWork.March.Day1.Q6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DistanceOfKInTree
 * @Description TODO  863. 二叉树中所有距离为 K 的结点  medium
 * @Author huangyq
 * @Date 2022/3/1 23:06
 * @Version
 **/
public class DistanceOfKInTree {
    //TODO 3.2
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        if(root==null){
            return new ArrayList<Integer>();
        }
        Map<TreeNode,TreeNode> memory = new HashMap<>();
        dfs(root,memory);

        ArrayList<Integer> result = new ArrayList<>();
        getNode(target,k,memory,result,target);
        return result;
    }

    private void getNode(TreeNode target, int k, Map<TreeNode, TreeNode> memory, ArrayList<Integer> result,TreeNode pre) {
        if(target==null||k<0){
            return ;
        }

        if(k==0){
            result.add(target.val);
            return ;
        }

        if(pre!=target.left) {
            getNode(target.left, k - 1, memory, result, target);
        }
        if(pre!=target.right) {
            getNode(target.right, k - 1, memory, result, target);
        }
        TreeNode parent = memory.get(target);
        if(pre!=parent) {
            getNode(parent, k - 1, memory, result, target);
        }


    }

    private void dfs(TreeNode root, Map<TreeNode, TreeNode> memory) {
        if(root==null){
            return ;
        }
        if(root.left!=null) {
            memory.put(root.left, root);
        }
        if(root.right!=null){
            memory.put(root.right,root);
        }

        dfs(root.left,memory);
        dfs(root.right,memory);
    }
}

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }