package com.hyqTestForWork.Janu.Day9.Q11;

import java.util.Stack;

/**
 * @ClassName TreeChange
 * @Description TODO 538 二叉搜索树变为二叉累加树  hot100  medium
 * @Author huangyq
 * @Date 2022/1/9 19:49
 * @Version
 **/
public class TreeChange {
    //迭代方式进行求解
    public TreeNode convertBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        int sum =0;
        TreeNode result = root;
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            sum = sum+ root.val;
            root.val = sum;
            root = root.left;
        }


        return result;
    }

    //递归方式求解——通过对迭代改写得到，但是直接写递归有点卡住——复习
    public TreeNode convertBST2(TreeNode root){

        dfs(root,0);
        return root;
    }

    public int dfs(TreeNode root,int value){

        if(root==null){
            return value ;
        }

        int valueRight = dfs(root.right,value);
        root.val += valueRight;
        int valueLeft = dfs(root.left,root.val);

        return valueLeft;
    }

    //Morris——树的结构变化没有还原，导致最后返回的树出问题——1.10复习理解了Morris再写一下；
    public TreeNode convertBST3(TreeNode root){

        Morris(root);

        return root;
    }

    public void Morris(TreeNode root){
        int sum=0;
        while(root!=null) {
            if (root.right != null) {
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                temp.left = root;
                TreeNode assist = root;
                root = root.right;
                assist.right = null;
            } else {
                sum+=root.val;
                root.val=sum;
                root = root.left;
            }
        }
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
