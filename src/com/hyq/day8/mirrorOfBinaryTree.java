package com.hyq.day8;

/**
 * @ClassName mirrorOfBinaryTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/5 7:23
 * @Version
 **/
public class mirrorOfBinaryTree {

    public static TreeNode mirrorTree(TreeNode root) {
        if(root != null)
            Deep(root);

        return root;
    }


    public static void Deep(TreeNode root) {
        if (root == null)
            return;

        if(root.left==null&&root.right==null)
            return ;

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        Deep(root.left);
        Deep(root.right);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}