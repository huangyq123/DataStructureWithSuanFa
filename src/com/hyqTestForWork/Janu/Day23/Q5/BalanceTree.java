package com.hyqTestForWork.Janu.Day23.Q5;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @ClassName BalanceTree
 * @Description TODO  110. 平衡二叉树  pindu  easy
 * @Author huangyq
 * @Date 2022/1/23 21:12
 * @Version
 **/
public class BalanceTree {

    public boolean isBalanced(TreeNode root) {

        int[] dfs = dfs(root, 0);
        return dfs[1]==0;
    }

    public int[] dfs(TreeNode root,int deep){
        if(root==null){
            return new int[]{deep,0};
        }

        int[] dfs1 = dfs(root.left, deep + 1);
        int[] dfs2 = dfs(root.right, deep + 1);

        int[] result = new int[2];
        if(dfs1[1]==-1||dfs2[1]==-1||Math.abs(dfs1[0]-dfs2[0])>1){
            result[1]=-1;
        }else{
            result[1]=0;
        }

        result[0] = Math.max(dfs1[0],dfs2[0]);
        return result;
    }

    //TODO 优化，减少判断

    public int[] dfsT(TreeNode root,int deep){
        if(root==null){
            return new int[]{deep,0};
        }

        int[] result = new int[2];

        int[] dfs1 = dfsT(root.left, deep + 1);
        if(dfs1[1]==-1){
             result[1]=-1;
             return result;
        }

        int[] dfs2 = dfsT(root.right, deep + 1);
        if(dfs2[1]==-1||Math.abs(dfs1[0]-dfs2[0])>1){
            result[1]=-1;
        }else{
            result[1]=0;
        }

        result[0] = Math.max(dfs1[0],dfs2[0]);
        return result;
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