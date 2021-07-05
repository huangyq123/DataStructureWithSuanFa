package com.hyq.day13;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

/**
 * @ClassName KthNodeInBinarySearchTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/11 19:33
 * @Version
 **/
public class KthNodeInBinarySearchTree {

    //遍历的本质——修改核心操作
    //递归顺序的影响
    public int kthLargest(TreeNode2 root, int k){
        if(root==null)
            return -1;

        ArrayList<TreeNode2> result = new ArrayList<>();
        Search(root,result);

        if(k>result.size())
            return -1;
        return result.get(result.size()-k).val;
    }

    public static void Search(TreeNode2 root, ArrayList<TreeNode2> memory){

        if(root==null)
            return;

        Search(root.left,memory);

        memory.add(root);

        Search(root.right,memory);

    }

}


class TreeNode2 {
      int val;
      TreeNode2 left;
      TreeNode2 right;
      TreeNode2(int x) { val = x; }
  }