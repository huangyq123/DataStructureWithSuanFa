package com.hyq.leetcode2.june.sixteen;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName PsthSum
 * @Description TODO  路径总和 113
 * @Author huangyq
 * @Date 2021/6/16 15:36
 * @Version
 **/
public class PathSum {

    public static List<List<Integer>> pathSum(TreeNode2 root, int targetSum) {

        List result = new ArrayList();

        if(root==null) {
            return result;
        }

        ArrayList<Integer> integers = new ArrayList<>();
        inDeep(result,root,targetSum,0,integers);


        return result;
    }

    //通过用例，但是空间利用过多 -？为啥
    //问题：  递归回溯的时候 状态什么时候进行消除选择错误；   最后保存结果时 值传递 和引用传递搞错；
    public static void inDeep(List result, TreeNode2 root, int target,int temp,ArrayList<Integer> memory){
        //走到叶节点
        if(root.left==null && root.right==null) {
            //状态记录
            memory.add(root.val);
            //满足条件
            if((temp+root.val)==target) {
                //存储数据  注意值传递和引用传递
                ArrayList<Integer> tx = new ArrayList<>();
                for(int k=0;k<=memory.size()-1;k++){
                    tx.add(memory.get(k));
                }
                //添加路径结果
                result.add(tx);
            }
            //状态消除
            memory.remove(memory.size()-1);
            return ;
        }

        //存储当前状态——数值路径
        memory.add(root.val);
        //往左子树查找
        if(root.left!=null){
            inDeep(result, root.left, target, temp + root.val,memory);
        }

        //往右子树查找
        if(root.right!=null){
            inDeep(result, root.right, target, temp + root.val,memory);
        }


        //状态消除  注意什么时候进行消除
        memory.remove(memory.size()-1);

        return ;
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(5);
        root.left = new TreeNode2(4);
        root.right=new TreeNode2(8);
        root.left.left = new TreeNode2(11);
        root.left.left.left = new TreeNode2(7);
        root.left.left.right=new TreeNode2(2);
        root.right.left=new TreeNode2(13);
        root.right.right=new TreeNode2(4);
        root.right.right.left=new TreeNode2(5);
        root.right.right.right=new TreeNode2(1);

        List<List<Integer>> lists = pathSum(root, 22);
        System.out.println(1);
    }

}

class TreeNode2 {
      int val;
      TreeNode2 left;
      TreeNode2 right;
      TreeNode2() {}
      TreeNode2(int val) { this.val = val; }
      TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
