package com.hyqTestForWork.Feb.Day18.Q4;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName kthNumInBST
 * @Description TODO 230. 二叉搜索树中第K小的元素 频度 medium
 * @Author huangyq
 * @Date 2022/2/18 21:12
 * @Version
 **/
public class kthNumInBST {
    public int kthSmallest(TreeNode root, int k) {

        List<TreeNode> list = new ArrayList<>();

        dfs(root,list);

        TreeNode treeNode = list.get(k - 1);

        return treeNode.val;
    }

    public void dfs(TreeNode root,List<TreeNode> list){

        if(root==null){
            return ;
        }

        dfs(root.left,list);
        list.add(root);
        dfs(root.right,list);
    }

    //思路二——每一个节点记录一个当前顺序（BST左小于中小于右），每次使用二分查找——记录优化：使用哈希表，这样可以保存原来结点的值
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
