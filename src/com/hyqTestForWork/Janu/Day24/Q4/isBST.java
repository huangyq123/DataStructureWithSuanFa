package com.hyqTestForWork.Janu.Day24.Q4;

/**
 * @ClassName isBST
 * @Description TODO  98. 验证二叉搜索树  频度  medium
 * @Author huangyq
 * @Date 2022/1/24 21:17
 * @Version
 **/
public class isBST {

    //可读性很差
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return false;
        }

        long[] result = dfs(root);

        return result[2]==1;
    }

    public long[] dfs(TreeNode root){

        if(root==null){
            return new long[]{0,0,0};
        }

        long[] result = new long[]{0,0,-1};

        long[] dfsLeft = dfs(root.left);
        if(dfsLeft[2]==-1){
            return result;
        }
        long[] dfsRight = dfs(root.right);
        if(dfsRight[2]==-1){
            return result;
        }

        if(dfsLeft[2]==0||dfsRight[2]==0){
            if(dfsLeft[2]!=0){
                if(dfsLeft[0]>=root.val){
                    return result;
                }else {
                    result[0] = dfsLeft[0];
                    result[1] = root.val;
                    result[2] = 1;
                }
            }else if(dfsRight[2]!=0){
                if(dfsRight[0]<=root.val){
                    return result;
                }else {
                    result[0] = root.val;
                    result[1] = dfsRight[1];
                    result[2] = 1;
                }
            }else{
                result[0] = root.val;
                result[1] = root.val;
                result[2] = 1;
            }
        }else if(dfsLeft[1]>=root.val||dfsRight[0]<=root.val){
            return result;
        }

        return result;
    }

    //TODO 如何在需要判断结果和其他参数的条件下写递归？？  ——> 进行转化，转化为从上往下的递归，这样就可以将参数作为函数参数进行传递，  1.25重写

    //中序遍历能写，但是考虑时间复杂度就没有写，不行的话就写这个
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
