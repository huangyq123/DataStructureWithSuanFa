package com.hyq.leetcode.Tree.question3;

import javax.swing.tree.TreeNode;

/**
 * @ClassName TreeRebuild
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/25 21:01
 * @Version
 **/
public class TreeRebuild {

    static int preStart = 0;
    public static TreeNode2 buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length!=inorder.length)
            return null;
        TreeNode2 result = ReBuild(preorder,inorder,0,inorder.length-1);
        return result;
    }

    public static TreeNode2 ReBuild(int[] preorder,int[] inorder, int inStart,int inEnd){
        if(inStart>inEnd||preStart>=preorder.length)
            return null;

        TreeNode2 currentNode = new TreeNode2(preorder[preStart++]);

        int index = 0;
        for(int i = inStart;i<=inEnd;i++){
            if(inorder[i]==preorder[preStart-1]){
                index  = i;
                break;
            }
        }

        if(index>=inStart)
        currentNode.left = ReBuild(preorder,inorder,inStart,index-1);
        if(index<=inEnd)
        currentNode.right = ReBuild(preorder,inorder,index+1,inEnd);

        return currentNode;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1};
        int[] b = new int[]{-1};
        TreeNode2 treeNode2 = buildTree(a, b);
        printTree(treeNode2);

    }


    public static void printTree(TreeNode2 root){
        if(root==null)
            return ;

        System.out.print(root.val+"   ");
        printTree(root.left);
        //System.out.print(root.val+"   ");
        printTree(root.right);
    }
}


class TreeNode2 {
      int val;
      TreeNode2 left;
      TreeNode2 right;
      TreeNode2() {}
      TreeNode2(int val) { this.val = val; }
      TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }