package com.hyq.day16;

import java.util.ArrayList;

/**
 * @ClassName CommonParentTwo
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/15 9:57
 * @Version
 **/
public class CommonParentTwo {

    public static TreeNode2 lowestCommonAncestor(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
        if(root==null)
            return null;

        ArrayList<Integer> tempOfp = new ArrayList<>();
        tempOfp.add(0);
        ArrayList<Integer> tempOfq = new ArrayList<>();
        tempOfq.add(0);

        find(root, p, tempOfp);
        find(root, q, tempOfq);

        int length = Math.min(tempOfp.size() - 1, tempOfq.size() - 1);
        int index = 0;
        while (index <=length) {

            if (tempOfp.get(index) != tempOfq.get(index))
                break;
            index++;
        }

        TreeNode2 result = root;
        for(int i =1;i<index;i++){
            if(tempOfp.get(i)==1)
                result = result.left;
            else
                result = result.right;
        }
        return result;
    }

    public static boolean find(TreeNode2 root, TreeNode2 target, ArrayList<Integer> temp) {
        if (root == null)
            return false;

        if (root.val == target.val)
            return true;

        boolean result = false;

        temp.add(1);
        result = find(root.left, target, temp);
        if (result)
            return true;
        else {
            temp.remove(temp.size() - 1);
            temp.add(2);
            result = find(root.right, target, temp);
            if (result)
                return result;
            else {
                temp.remove(temp.size() - 1);
                return result;
            }
        }


    }

    public static void main(String[] args) {
        TreeNode2 head = new TreeNode2(3);
        head.left = new TreeNode2(5);
        head.right = new TreeNode2(1);
        TreeNode2 cur = head.left;
        cur.left = new TreeNode2(6);
        cur.right = new TreeNode2(2);
        cur = head.right;
        cur.left = new TreeNode2(0);
        cur.right = new TreeNode2(8);
        cur = head.left.right;
        cur.left = new TreeNode2(7);
        cur.right = new TreeNode2(4);

        TreeNode2 p = new TreeNode2(6);
        TreeNode2 q = new TreeNode2(0);
lowestCommonAncestor(head,p,q);
    }

}

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int x) {
        val = x;
    }
}