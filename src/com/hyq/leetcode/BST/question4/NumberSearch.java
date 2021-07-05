package com.hyq.leetcode.BST.question4;


/**
 * @ClassName NumberSearch
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/28 20:59
 * @Version
 **/
public class NumberSearch {

    public TreeNode8 searchBST(TreeNode8 root, int val) {
        if (root == null)
            return null;

        return Recur(root, val);
    }

    public static TreeNode8 insertIntoBST(TreeNode8 root, int val) {
        if(root == null)
         root = new TreeNode8(val);
        else
        Insert(root,val);
        return root;
    }

    public static void Insert(TreeNode8 root, int val) {

        if (root.val == val)
            return;

        if (root.val < val){
            if(root.right==null){
                root.right = new TreeNode8(val);
                return ;
            }
            Insert(root.right, val);
        }
        else{
            if(root.left==null){
                root.left = new TreeNode8(val);
                return ;
            }
            Insert(root.left, val);
        }


    }


    //要能构造成普通二叉树的形式
    public static TreeNode8 Recur(TreeNode8 root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        if (root.val > val)
            return Recur(root.left, val);
        else
            return Recur(root.right, val);
    }
}


class TreeNode8 {
    int val;
    TreeNode8 left;
    TreeNode8 right;

    TreeNode8() {
    }

    TreeNode8(int val) {
        this.val = val;
    }

    TreeNode8(int val, TreeNode8 left, TreeNode8 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}