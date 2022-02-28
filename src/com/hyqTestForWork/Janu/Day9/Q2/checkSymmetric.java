package com.hyqTestForWork.Janu.Day9.Q2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName checkSymmetic
 * @Description TODO 101 对称二叉树  hot100 easy
 * @Author huangyq
 * @Date 2022/1/9 10:52
 * @Version
 **/
public class checkSymmetric {
    //看题解写的——递归:理解——两棵树的对称性：树1左子树和树2右子树的对称性，树1右子数和树2左子树，根节点；
    public boolean isSymmetric(TreeNode root) {

        boolean check = check(root, root);

        return check;
    }

    public boolean check(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }

        if(root1.val==root2.val){
            boolean check1 = check(root1.left, root2.right);
            boolean check2 = check(root1.right, root2.left);
            if(check1&&check2){
                return true;
            }
        }

        return false;
    }


    //迭代——1.10实现
    public boolean isSymmetric2(TreeNode root) {



        return false;
    }

//    public void leftSearch(TreeNode root,List<Integer> result){
//        if(root==null){
//            return ;
//        }
//
//        if(root.left!=null) leftSearch(root.left, result);
//        result.add(root.val);
//        if(root.right!=null) leftSearch(root.right,result);
//    }
//
//    public void rightSearch(TreeNode root,List<Integer> result){
//        if(root==null){
//            return ;
//        }
//
//        if(root.right!=null) rightSearch(root.right, result);
//        result.add(root.val);
//        if(root.left!=null) rightSearch(root.left,result);
//    }
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

