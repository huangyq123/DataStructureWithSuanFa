package com.hyqTestForWork.Janu.Day9.Q1;

/**
 * @ClassName RadiusOfTree
 * @Description TODO 543 二叉树直径  hot100 easy
 * @Author huangyq
 * @Date 2022/1/9 10:22
 * @Version
 **/
public class RadiusOfTree {
    //不会，看题解做的——理解：直径必定经过某个子树根节点且两端在该根节点的左右子树中，将所有节点的直径计算出来取最大值；
    //  通过递归计算该节点未根节点的树的深度，用于计算直径
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result=new int[]{0};
        depth(root,result);

        return result[0];
    }

    public int depth(TreeNode root,int[] result){
        if(root==null){
            return 0;
        }

        int leftDepth = depth(root.left,result);
        int rightDepth = depth(root.right,result);

        if(leftDepth+rightDepth>result[0]){
            result[0]=leftDepth+rightDepth;
        }
        return Math.max(leftDepth,rightDepth)+1;
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
