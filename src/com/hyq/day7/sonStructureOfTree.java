package com.hyq.day7;

/**
 * @ClassName sonStructureOfTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/4 11:19
 * @Version
 **/
public class sonStructureOfTree {

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;


        boolean result = true;
        if (A.val != B.val) {
            if (A.left == null && A.right == null)
                return false;
            else if (A.left != null) {
                result = isSubStructure(A.left, B);
            } else if (A.right != null)
                result = isSubStructure(A.right, B);
        }


        if (B.left == null && B.right == null)
            return true;

        if (B.left != null) {
            if (A.left == null)
                result = false;
            else
                result = isSubStructure(A.left, B.left);
        }

        if (B.right != null && result) {
            if (A.right == null)
                result = false;
            else
                result = isSubStructure(A.right, B.right);
        }


        //Boolean resultLeft = false;
        //Boolean resultRight = isSubStructure(A.right, B.right);


        return result;
    }

//递归查找所有可能起始点（遍历二叉树）；找到起始点之后使用回溯（走迷宫方法）来查找子结构
    public static boolean isSubStructure2(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;

        boolean result = false;

        if (A.val == B.val)
            result = Decide(A, B);

        if (!result)
            result = isSubStructure2(A.left, B);
        if (!result)
            result = isSubStructure2(A.right, B);


        return result;
    }


    public static boolean Decide(TreeNode A, TreeNode B) {
        if (A == null || A.val != B.val)
            return false;

        if (B.left == null && B.right == null)
            return true;

        boolean result = true;
        if (B.left != null)
            result = result && Decide(A.left, B.left);
        if (B.right != null)
            result = result && Decide(A.right, B.right);

        return result;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}