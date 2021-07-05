package com.hyq.leetcode.BST.question1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName KthSmallNumber
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/28 19:14
 * @Version
 **/
public class KthSmallNumber {

//    static int count = 0;
//    public int kthSmallest(TreeNode5 root, int k) {
//        if(root==null||k<0)
//            return -1;
//
//        Recur(root,k);
//        return count;
//
//    }
//
//    //倒数第k个
//    public static int Recur(TreeNode5 root,int k){
//        if(root == null)
//            return -1;
//
//        Recur(root.right,k);
//        if(count==k-1)
//            return root.val;
//
//        count+=1;
//        return Recur(root.left,k);
//    }

    public static int kthSmallest(TreeNode5 root, int k) {
        if(root==null||k<=0)
            return -1;
        List<TreeNode5> memory = new ArrayList<>();
        return Recur(root,memory,k);
    }

    public static int Recur(TreeNode5 root, List<TreeNode5> memory,int k){         //可以在空间效率进行优化——只记录数字序号和结果，不需要使用列表
        if(root == null)
            return -1;
        int temp = Recur(root.left,memory,k);
        if(temp>=0)    //边界条件：考虑节点值，可能的范围为非负，需要考虑等号
            return temp;

        if(memory.size()==k-1)
            return root.val;

        memory.add(root);
        return Recur(root.right,memory,k);
    }

    public static void main(String[] args) {
        TreeNode5 head = new TreeNode5(3);
        head.right = new TreeNode5(4);
        head.left = new TreeNode5(1);
        head.left.right = new TreeNode5(2);

        System.out.println(kthSmallest(head,1));
    }

}


  class TreeNode5 {
      int val;
      TreeNode5 left;
      TreeNode5 right;
      TreeNode5() {}
      TreeNode5(int val) { this.val = val; }
      TreeNode5(int val, TreeNode5 left, TreeNode5 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }