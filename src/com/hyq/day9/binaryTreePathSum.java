package com.hyq.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName binaryTreePathSum
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/7 16:15
 * @Version
 **/
public class binaryTreePathSum {

    public static List<List<Integer>> pathSum(TreeNode2 root, int sum) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<List<Integer>> result = new ArrayList<>();
        int currentSum = 0;
        ArrayList<Integer> temp = new ArrayList<>();

        Deep(result, temp, root, sum, currentSum);

        return result;
    }

    public static void Deep(ArrayList<List<Integer>> result, ArrayList<Integer> temp, TreeNode2 root, int sum, int currentSum) {


        if (root.left == null&&root.right==null){
            if ((currentSum + root.val) == sum) {
                temp.add(root.val);
                ArrayList<Integer> assist = new ArrayList<>();
                assist.addAll(temp);
                result.add(assist);
                temp.remove(temp.size() - 1);
            }
            return;
        }


        temp.add(root.val);
        if(root.left!=null) Deep(result, temp, root.left, sum, currentSum + root.val);
        if(root.right!=null) Deep(result, temp, root.right, sum, currentSum + root.val);
        temp.remove(temp.size() - 1);
        return;
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