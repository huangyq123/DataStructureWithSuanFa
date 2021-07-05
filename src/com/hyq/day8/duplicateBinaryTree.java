package com.hyq.day8;

import java.util.ArrayList;

/**
 * @ClassName duplicateBinaryTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/5 9:03
 * @Version
 **/
public class duplicateBinaryTree {

    public boolean isSymmetric(TreeNode2 root){
        ArrayList<Integer> resultOne = new ArrayList<>();
        ArrayList<Integer> resultTwo = new ArrayList<>();

        qianxvBianli(root,resultOne);
        qianxvBianli2(root,resultTwo);

        if(root==null)
            return false;

        boolean result = true;
        for(int i=0;i<resultOne.size();i++){
            if(!resultOne.get(i).equals(resultTwo.get(i))){
                result = false;
                break;
            }
        }

        return result;
    }

    public static void qianxvBianli(TreeNode2 root, ArrayList<Integer> result){
        if(root == null){
            result.add(-1);
            return ;
        }

        result.add(root.val);
        qianxvBianli(root.left,result);
        qianxvBianli(root.right,result);
    }

    public static void qianxvBianli2(TreeNode2 root,ArrayList<Integer> result){
        if(root == null){
            result.add(-1);
            return ;
        }

        result.add(root.val);
        qianxvBianli2(root.right,result);
        qianxvBianli2(root.left,result);
    }
}


 class TreeNode2 {
      int val;
      TreeNode2 left;
      TreeNode2 right;
      TreeNode2(int x) { val = x; }
  }