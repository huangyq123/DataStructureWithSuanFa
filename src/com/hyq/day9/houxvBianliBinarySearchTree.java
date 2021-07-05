package com.hyq.day9;

/**
 * @ClassName houxvBianliBinarySearchTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/7 14:35
 * @Version
 **/
public class houxvBianliBinarySearchTree {

    public static void main(String[] args) {
        int[] test = {4,6,7,5};
        boolean b = verifyPostorder(test);
        System.out.println(b);
    }

    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null)
            return false;
        boolean result = isPostorder(postorder, 0, postorder.length - 1);
        return result;
    }

    //边界问题的考虑;算法原理
    public static boolean isPostorder(int[] postorder, int start, int end) {
        if (end <= start)
            return true;

        boolean result = true;
        int root = end;
        int left = start - 1;
        int right = start - 1;

        for (int i = start; i < root; i++) {
            if (postorder[i] > postorder[root]) {
                right = i;
                break;
            }
            left = i;
        }

        if (right >= start) {       //含义
            for (int k = right; k < root; k++) {
                if (postorder[k] < postorder[root]) {
                    result = false;
                    break;
                }
            }
        }


        if (!result)
            return false;

        if (right < start)
            return isPostorder(postorder, start, left);
        else if (left < start)
            return  isPostorder(postorder, right, end - 1);
        else
            return isPostorder(postorder, start, left) && isPostorder(postorder, right, end - 1);
//优化
//        return isPostorder(postorder, start, left) && isPostorder(postorder, left+1, end - 1);
    }
}
