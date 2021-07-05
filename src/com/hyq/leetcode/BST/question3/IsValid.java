package com.hyq.leetcode.BST.question3;



import javax.swing.tree.TreeNode;

/**
 * @ClassName IsValid
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/28 20:13
 * @Version
 **/
public class IsValid {

    public static boolean isValidBST(TreeNode7 root) {
        if(root==null)
            return true;

       return Recur2(root);
    }

    static TreeNode7 pre = null;
    //中序遍历
    public static boolean Recur2(TreeNode7 root){
        if(root==null)
            return true;

        if(Recur2(root.left)){
            if(pre==null||root.val>pre.val)      //会有许多冗余判断，可以将pre从存储节点改为存储值，初始值为Long型最小值
                pre = root;
            else
                return false;
        }
        else
            return false;

       return Recur2(root.right);
    }
}

class TreeNode7 {
    int val;
    TreeNode7 left;
    TreeNode7 right;
    TreeNode7() {}
    TreeNode7(int val) { this.val = val; }
    TreeNode7(int val, TreeNode7 left,  TreeNode7 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
