package com.hyq.leetcode.Tree.question5;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName SerializableBinaryTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/27 18:35
 * @Version
 **/
public class SerializableBinaryTree {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode4 root) {
        StringBuffer temp = new StringBuffer();
        Queue<TreeNode4> memory = new LinkedList<>();
        memory.add(root);

        while(!memory.isEmpty()){
            for(int k =memory.size();k>0;k--){
                TreeNode4 now = memory.poll();
                if(now == null) { temp.append("#"+",");  continue;}
                temp.append(now.val+",");
                memory.add(now.left);
                memory.add(now.right);
            }
        }
        return temp.substring(0,temp.length()-1);
    }

    //字符串分割要注意原格式；字符串比较要注意使用equals方法
    // Decodes your encoded data to tree.
    public static TreeNode4 deserialize(String data) {
        TreeNode4 head=null;
        String[] temp = data.split(",");
        if(temp[0]=="#")
            return head;

        TreeNode4[] t = new TreeNode4[temp.length];
        t[0] = new TreeNode4(Integer.parseInt(temp[0]));
        head = t[0];

        int k = 1;
        int current = 0;
        while(k<temp.length){
            if(!temp[current].equals("#")){
                if(!temp[k].equals("#")) {t[k] = new TreeNode4(Integer.parseInt(temp[k]));}
                else {t[k] = null;}
                t[current].left = t[k++];

                if(!temp[k].equals("#")) {t[k] = new TreeNode4(Integer.parseInt(temp[k]));}
                else {t[k] = null;}
                t[current].right = t[k++];
            }
                current++;
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode4 head = new TreeNode4(1);
        head.left = new TreeNode4(2);
        head.right = new TreeNode4(3);
        head.right.left = new TreeNode4(4);
        head.right.right = new TreeNode4(5);

        System.out.println(serialize(head));
        deserialize(serialize(head));
    }
}

  class TreeNode4 {
      int val;
      TreeNode4 left;
      TreeNode4 right;
      TreeNode4(int x) { val = x; }
  }