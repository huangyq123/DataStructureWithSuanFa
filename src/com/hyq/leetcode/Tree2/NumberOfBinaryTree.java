package com.hyq.leetcode.Tree2;


import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NumberOfBineryTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/29 21:27
 * @Version
 **/
public class NumberOfBinaryTree {

    //时间复杂度过高
    public int countNodes(TreeNodeA root) {
         int count = 0;
         int end = 0;

         if(root==null)
             return count;

        Queue<TreeNodeA> memory = new LinkedList<>();
        memory.add(root);
        while(!memory.isEmpty()){  //查找第一个不含有完整子节点的节点
            count+=1;
            TreeNodeA temp = memory.poll();
            if(temp.left==null){end = 0;break;}
            if(temp.right==null){end = 1; break;}
            memory.add(temp.left);
            memory.add(temp.right);
        }
        if(end==0)              //根据找到的节点是否有子节点计算总的节点数
            return count*2-1;
        else
            return count*2;
    }


//    public static boolean Find(TreeNodeA root){
//        if(root==null)
//            return false;
//
//        count+=1;
//        if(root.left==null) {
//            end = 0;
//            return true;
//        }else if(root.right==null){
//            end = 1;
//            return true;
//        }
//
//        return Find(root.left)||Find(root.right);
//
//    }
}
class TreeNodeA {
      int val;
      TreeNodeA left;
     TreeNodeA right;
     TreeNodeA() {}
     TreeNodeA(int val) { this.val = val; }
     TreeNodeA(int val, TreeNodeA left, TreeNodeA right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}