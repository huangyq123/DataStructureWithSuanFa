package com.hyq.day10;

/**
 * @ClassName BinarySearchTreeToDoubleList
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/8 9:32
 * @Version
 **/
public class BinarySearchTreeToDoubleList {


    //问题：未测试边界条件的测试用例，直接使用OJ来测试
    public Node2 treeToDoublyList(Node2 root) {
        if (root == null)
            return root;

        Node2 father= new Node2(-1);
        father.left = root;
        Node2 end = Recur(father,root);


        Node2 head = root;
        while (head.left != null) {
            head = head.left;
        }
        head.left = end;
        end.right = head;

        return head;

    }

    public static Node2 Recur(Node2 father, Node2 root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;

        Node2 left = Recur(root, root.left);
        root.left = left;
        if(left!= null) left.right = root;
        Node2 right = Recur(root, root.right);
        root.right = right;
        if(right!=null) right.left = root;

        Node2 result = root;
        if (father.left == root) {
            while (result.right != null) {
                result = result.right;
            }

        } else if (father.right == root) {
            while (result.left != null) {
                result = result.left;
            }
        }
        return result;
    }
}


class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {
    }

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};