package com.hyq.day10;


import com.hyq.day3.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName serializableAndDeseeializableTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/8 13:34
 * @Version
 **/
public class serializableAndDeserializableTree {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        TreeNode temp = head.right;
        temp.left = new TreeNode(4);
        temp.right = new TreeNode(5);
        String str = serialize(head);
        TreeNode result = deserialize(str);
        System.out.println(1);
    }

    //问题：边界条件，修改代码时要注意边界条件的变化；
    //     if\else的省略写法
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return new String("");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                stringBuffer.append(temp.val + ",");
                queue.add(temp.left);
                queue.add(temp.right);
            } else{
                stringBuffer.append("null,");
                queue.add(null);
                queue.add(null);
            }
        }

        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append("]");
        String result = stringBuffer.toString();
        return result;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;

        String str = data.substring(1, data.length() - 1);
        String[] source = str.split(",");
        TreeNode[] assist = new TreeNode[source.length];

        for (int i = 0; i < source.length; i++) {
            if (source[i].equals("null")) assist[i] = null;
            else assist[i] = new TreeNode(Integer.parseInt(source[i]));

//                if(source[i].equals("null"))
//                    continue;
//                if(!source[2*i+1].equals("null")) currentNode.left = new TreeNode(Integer.parseInt(source[2*i+1]));
//                if(!source[2*i+2].equals("null")) currentNode.right = new TreeNode(Integer.parseInt(source[2*i+2]));
        }

        for (int i = 0; i < source.length / 2; i++) {
            if (assist[i] != null) {
                assist[i].left = assist[2 * i + 1];
                assist[i].right = assist[2 * i + 2];
            }
        }
        return assist[0];
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

