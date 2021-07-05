package com.hyq.leetcode.BST.question5;



import javax.swing.tree.TreeNode;

/**
 * @ClassName deleteNode
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/28 22:20
 * @Version
 **/
public class deleteNode {

    public static TreeNode9 deleteNode(TreeNode9 root, int key) {
        pre.left=root;
        TreeNode9 resultNode = Recur(root, key);
        if (resultNode == null){
            if(pre.val==-1)
                return pre.left;
            else
                return root;
        }

        else {
            if (resultNode.left == null && resultNode.right == null) {
                if (position == 1)
                    pre.left = null;
                else if (position == 2)
                    pre.right = null;
            } else {
                TreeNode9 temp = resultNode;
                TreeNode9 currentNode = null;
                if (resultNode.left != null) {
                    currentNode = temp.left;
                    while (currentNode.right != null) {
                        temp = currentNode;
                        currentNode = temp.right;
                    }
                    if (position == 1)
                        pre.left = currentNode;
                    else if (position == 2)
                        pre.right = currentNode;
                    if(temp!=resultNode){
                        temp.right = null;
                        currentNode.left = resultNode.left;
                    }
                        currentNode.right = resultNode.right;

                } else if (resultNode.right != null) {
                    currentNode = temp.right;
                    while (currentNode.left != null) {
                        temp = currentNode;
                        currentNode = temp.left;
                    }
                    if (position == 1)
                        pre.left = currentNode;
                    else if (position == 2)
                        pre.right = currentNode;
                    if(temp!=resultNode){
                        temp.left = null;
                        currentNode.right = resultNode.right;
                    }
                    currentNode.left = resultNode.left;
                }
            }
        }

            if(pre.val==-1)
                return pre.left;
            else
                return root;

    }

    public static void main(String[] args) {
        TreeNode9 head = new TreeNode9(5);
        head.left = new TreeNode9(3);
        head.right = new TreeNode9(6);
        head.left.left = new TreeNode9(2);
        head.left.right = new TreeNode9(4);
        head.right.right = new TreeNode9(7);
        TreeNode9 treeNode9 = deleteNode(head, 5);
        System.out.println(treeNode9.val);
    }


    static TreeNode9 pre = new TreeNode9(-1);
    static int position = 1;

    public static TreeNode9 Recur(TreeNode9 root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        if (root.val > val) {
            pre = root;
            position = 1;
            return Recur(root.left, val);
        } else {
            pre = root;
            position = 2;
            return Recur(root.right, val);
        }


    }

}


class TreeNode9 {
    int val;
    TreeNode9 left;
    TreeNode9 right;

    TreeNode9() {
    }

    TreeNode9(int val) {
        this.val = val;
    }

    TreeNode9(int val, TreeNode9 left, TreeNode9 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
