package com.hyq.day9;

import java.util.*;

/**
 * @ClassName binaryTreePrint
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/7 10:44
 * @Version
 **/
public class binaryTreePrint {

    //之字分层打印优化
    public List<List<Integer>> levelOrder3Opyimize(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();

        Queue<TreeNode> node = new LinkedList<>();
        ArrayList<List<Integer>> trueResult = new ArrayList<>();

        node.add(root);
        int count = 0;
        while (!node.isEmpty()) {
            LinkedList<Integer> result = new LinkedList<>();
                for (int i = node.size()-1;i>=0; i--) {
                    TreeNode temp = node.poll();
                    if((count&1)==0)  result.addLast(temp.val);
                    else result.addFirst(temp.val);
                    if (temp.left != null) { node.add(temp.left); }
                    if (temp.right != null) { node.add(temp.right); }
                }
            trueResult.add(result);
            count++;
        }
        return trueResult;
    }


    //之字型打印
    public List<List<Integer>> levelOrder3(TreeNode root) {

        if (root == null)
            return new ArrayList<List<Integer>>();

        ArrayList<TreeNode> node = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> flag = new ArrayList<>();
        node.add(root);
        flag.add(0);
        int count = 0;

        while (count < node.size()) {
            TreeNode temp = node.get(count);
            result.add(temp.val);
            if (temp.left != null) {
                node.add(temp.left);
                flag.add(flag.get(count) + 1);
            }
            if (temp.right != null) {
                node.add(temp.right);
                flag.add(flag.get(count) + 1);
            }
            count++;
        }

        ArrayList<List<Integer>> trueResult = new ArrayList<>();
        int max = flag.get(flag.size() - 1);
        int index = 0;
        for (int i = 0; i <= max; i++) {
            ArrayList<Integer> rowResult = new ArrayList<>();
            while (index < flag.size() && flag.get(index) == i) {
                rowResult.add(result.get(index));
                index++;
            }
            if ((i & 1) == 1) {
                Collections.reverse(rowResult);
            }
            trueResult.add(rowResult);
        }

        return trueResult;
    }

    //分层打印优化
    public List<List<Integer>> levelOrder2Opyimize(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();

        Queue<TreeNode> node = new LinkedList<>();
        ArrayList<List<Integer>> trueResult = new ArrayList<>();

        node.add(root);

        while (!node.isEmpty()) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = node.size() - 1; i >= 0; i--) {
                TreeNode temp = node.poll();
                result.add(temp.val);
                if (temp.left != null) {
                    node.add(temp.left);
                }
                if (temp.right != null) {
                    node.add(temp.right);
                }
            }
            trueResult.add(result);
        }
        return trueResult;
    }

    //分层打印
    public List<List<Integer>> levelOrder2(TreeNode root) {

        if (root == null)
            return new ArrayList<List<Integer>>();

        ArrayList<TreeNode> node = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> flag = new ArrayList<>();
        node.add(root);
        flag.add(0);
        int count = 0;

        while (count < node.size()) {
            TreeNode temp = node.get(count);
            result.add(temp.val);
            if (temp.left != null) {
                node.add(temp.left);
                flag.add(flag.get(count) + 1);
            }
            if (temp.right != null) {
                node.add(temp.right);
                flag.add(flag.get(count) + 1);
            }
            count++;
        }

        ArrayList<List<Integer>> trueResult = new ArrayList<>();
        int max = flag.get(flag.size() - 1);
        int index = 0;
        for (int i = 0; i <= max; i++) {
            ArrayList<Integer> rowResult = new ArrayList<>();
            while (index < flag.size() && flag.get(index) == i) {
                rowResult.add(result.get(index));
                index++;
            }
            trueResult.add(rowResult);
        }

        return trueResult;
    }

    //搞清楚遍历类型
    //队列怎么用？
    public int[] levelOrder(TreeNode root) {

        if (root == null)
            return new int[]{};

        ArrayList<TreeNode> node = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        node.add(root);
        int count = 0;
        while (count < node.size()) {
            TreeNode temp = node.get(count);
            result.add(temp.val);
            if (temp.left != null) {
                node.add(temp.left);
            }
            if (temp.right != null) {
                node.add(temp.right);
            }
            count++;
        }

        int[] trueResult = new int[result.size()];
        for (int i = 0; i < trueResult.length; i++) {
            trueResult[i] = result.get(i);
        }

        return trueResult;
    }


//递归用于三种遍历：前序、中序、后序
//    public static void mediumPrint(ArrayList<Integer> result, TreeNode root){
//
//        if(root == null)
//            return ;
//
//        result.add(root.val);
//
//         mediumPrint(result,root.left);
//         mediumPrint(result,root.right);
//
//        return ;
//    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}