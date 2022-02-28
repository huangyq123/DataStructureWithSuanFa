package com.hyqTestForWork.Janu.Day9.Q8;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MergeTree
 * @Description TODO  617  合并二叉树  hot100 easy
 * @Author huangyq
 * @Date 2022/1/9 15:54
 * @Version
 **/
public class MergeTree {
    //dfs实现——写的过于复杂
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        TreeNode root3 = new TreeNode();
        dfs(root1,root2,root3);

        return root3;
    }


    public boolean dfs(TreeNode root1,TreeNode root2,TreeNode root3){
        if(root1==null&&root2==null){
            root3=null;
            return false;
        }

        root3.left=new TreeNode();
        root3.right = new TreeNode();
        if(root1==null) {
            root3.val = root2.val;
            if(dfs(null, root2.left, root3.left)){
                root3.left=null;
            }
            if(dfs(null,root2.right,root3.right)) {
                root3.right=null;
            }
        }else if(root2==null){
            root3.val=root1.val;
            if(dfs(root1.left,null, root3.left)){
                root3.left=null;
            }
            if(dfs(root1.right,null,root3.right)){
                root3.right=null;
            }
        }else{
            root3.val = root1.val+root2.val;
            if(dfs(root1.left,root2.left, root3.left)){
                root3.left=null;
            }
            if(dfs(root1.right,root2.right,root3.right)){
                root3.right=null;
            }
        }

        return true;
    }


    @Test
    public void Test(){
        TreeNode test1 = new TreeNode(1,new TreeNode(3),new TreeNode(2));
        test1.left.left=new TreeNode(5);

        TreeNode test2 = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        test2.left.right = new TreeNode(4);
        test2.right.right=new TreeNode(7);

        mergeTrees(test1,test2);
    }


    //优化版dfs_考虑dfs函数的返回结果——某个子树为空时不进行新节点构造，而是选择直接拼接
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {

        TreeNode result = dfs2(root1,root2);

        return result;
    }

    public TreeNode dfs2(TreeNode root1,TreeNode root2){
        if(root1==null){
            return root2;
        }else if(root2==null){
            return root1;
        }

        TreeNode returnValue = new TreeNode(root1.val+root2.val);
        returnValue.left = dfs2(root1.left,root2.left);
        returnValue.right = dfs2(root1.right,root2.right);
        return returnValue;
    }



    //迭代实现——问题：没有办法保证结点的联系——没写出来——1.10任务
    public TreeNode mergeTrees3(TreeNode root1, TreeNode root2){

        Queue<TreeNode> queue1= new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
//        if(root1==null){
//            return root2;
//        }
//        if(root2==null){
//            return root1;
//        }
        queue1.add(root1);
        queue2.add(root2);
        TreeNode result = null;
        while(!queue1.isEmpty()&&!queue2.isEmpty()){
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if(node1==null){
                result = node2;
            }else if(node2==null){
                result = node1;
            }else {
                result = new TreeNode(node1.val+node2.val);
            }
        }
        return null;
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
