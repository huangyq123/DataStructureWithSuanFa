package com.hyq.leetcode.BST.question2;



import javax.swing.tree.TreeNode;

/**
 * @ClassName BSTtoSumTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/28 19:59
 * @Version
 **/
public class BSTtoSumTree {

    public TreeNode6 bstToGst(TreeNode6 root) {
        if(root  == null)
            return null;

        Recur(root);
        return root;
    }

    static int sum = 0;
    public static void Recur(TreeNode6 root){
        if(root==null)
            return ;

        Recur(root.right);

        root.val+=sum;
        sum=root.val;

        Recur(root.left);
    }

}

class TreeNode6 {
    int val;
    TreeNode6 left;
    TreeNode6 right;
    TreeNode6() {}
    TreeNode6(int val) { this.val = val; }
    TreeNode6(int val, TreeNode6 left, TreeNode6 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
