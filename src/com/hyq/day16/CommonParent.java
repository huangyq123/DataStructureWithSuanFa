package com.hyq.day16;

/**
 * @ClassName CommonParent
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/15 9:19
 * @Version
 **/
public class CommonParent {

    static TreeNode result ;
    public static  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        result = root;
        Find(root, p, q);
        return result;
    }

    public static void Find(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val > Math.min(p.val ,q.val)&& root.val <  Math.max(p.val ,q.val)) {
            result = root;
        } else if (root.val == p.val) {
            result = root;
        } else if (root.val == q.val) {
            result = root;
        } else if (root.val >  Math.max(p.val ,q.val)) {
            Find(root.left, p, q);
        } else if (root.val < Math.min(p.val ,q.val)) {
            Find(root.right, p, q);
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(6);
        head.left = new TreeNode(2);
        head.right = new TreeNode(8);
        TreeNode cur = head.left;
        cur.left = new TreeNode(0);
        cur.right = new TreeNode(4);
        cur = head.right;
        cur.left = new TreeNode(7);
        cur.right = new TreeNode(9);
        cur = head.left.right;
        cur.left = new TreeNode(3);
        cur.right = new TreeNode(5);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        lowestCommonAncestor(head,p,q);
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