package com.hyqTestForWork.Janu.Day21.Q5;


import org.junit.Test;

/**
 * @ClassName ReturnTree
 * @Description TODO 105  从前序与中序遍历序列构造二叉树 频度 medium
 * @Author huangyq
 * @Date 2022/1/21 20:21
 * @Version
 **/
public class ReturnTree {
    //思路正确，细节上对于递归结束的判断写错了——注意细节
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode result = sonBuild(preorder, inorder, 0, 0, preorder.length - 1, inorder.length - 1);
        return result;
    }

    public TreeNode sonBuild(int[] preorder,int[] inorder,int leftPre,int leftIn,int rightPre,int rightIn){

        if(rightPre-leftPre<0){
            return null;
        }else if(rightPre-leftPre==0){
            return new TreeNode(preorder[leftPre]);
        }


        TreeNode root = new TreeNode(preorder[leftPre]);
        int index = 0;
        for(int i=leftIn;i<=rightIn;i++){
            if(inorder[i]==preorder[leftPre]){
                index = i;
                break;
            }
        }

       root.left =  sonBuild(preorder,inorder,leftPre+1,leftIn,leftPre+index-leftIn,index-1);
       root.right =  sonBuild(preorder,inorder,leftPre+index-leftIn+1,index+1,rightPre,rightIn);

        return root;
    }

    @Test
    public void Test(){
        TreeNode test = new TreeNode(3,new TreeNode(9),new TreeNode(20));
        test.right.left = new TreeNode(15);
        test.right.right = new TreeNode(7);
        buildTree(new int[]{1,2}, new int[]{2,1});
    }


    //TODO 迭代实现  1.22

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
