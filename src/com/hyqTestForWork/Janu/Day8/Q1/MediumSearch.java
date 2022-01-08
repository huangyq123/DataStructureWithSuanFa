package com.hyqTestForWork.Janu.Day8.Q1;


import org.junit.Test;

import java.util.*;

/**
 * @ClassName MediumSearch
 * @Description TODO 94  中序遍历二叉树  hot100 easy
 * @Author huangyq
 * @Date 2022/1/8 18:49
 * @Version
 **/
public class MediumSearch {

    //递归实现遍历
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }

        traversal(root,result);

        return result;
    }

    public void traversal(TreeNode root,List<Integer> result){

        if(root.left!=null) traversal(root.left,result);
        result.add(root.val);
        if(root.right!=null) traversal(root.right,result);
    }

    //迭代实现遍历
    //没写出来，看的题解——理解：迭代要从压栈和出栈节点的顺序来理解转化
    public List<Integer> inorderTraversal2(TreeNode root){
//        Stack<TreeNode> memory = new Stack<>();
//
//        List<Integer> result=new ArrayList<>();
//        if(root!=null){
//            memory.push(root);
//        }else{
//            return result;
//        }
//
//        while(!memory.isEmpty()){
//            TreeNode peek = memory.peek();
//            if(peek.left!=null){
//                memory.push(peek.left);
//                continue;
//            }
//            result.add(peek.val);
//            TreeNode pop = memory.pop();
//            if(pop.right!=null){
//                memory.push(pop.right);
//                continue;
//            }
//        }
//        return result;

        //题解
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    //morris遍历——1.9任务

    @Test
    public void Test(){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=null;
        treeNode.right=new TreeNode(2);
        treeNode.right.left=new TreeNode(3);
        inorderTraversal2(treeNode);
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