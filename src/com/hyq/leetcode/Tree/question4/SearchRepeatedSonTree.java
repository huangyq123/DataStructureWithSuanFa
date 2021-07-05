package com.hyq.leetcode.Tree.question4;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @ClassName SearchRepeatedSonTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/27 17:49
 * @Version
 **/
public class SearchRepeatedSonTree {

    public List<TreeNode3> findDuplicateSubtrees(TreeNode3 root) {
        List<TreeNode3> result = new ArrayList<>();
        HashMap<String,Integer> memory = new LinkedHashMap<>();
        SearchSonTree(root,result,memory);
        return result;
    }

    //方法功能——判断当前子树是否重复：得到当前序列，与其他序列进行比较
    //整体功能和返回值不等同，返回值可以是用于解决某些步骤
    //二叉树结构的判断通常用序列化来实现
    public static String SearchSonTree(TreeNode3 root, List<TreeNode3> temp, HashMap<String,Integer> memory){
        if(root==null)
            return "#";

        String left = SearchSonTree(root.left,temp,memory);
        String right = SearchSonTree(root.right,temp,memory);
        String rootValue = left+","+right+","+root.val;

        if(!memory.containsKey(rootValue)){
            memory.put(rootValue,1);
        }else if(memory.get(rootValue)==1){
            temp.add(root);
            memory.put(rootValue,2);
        }

        return rootValue;
    }
}

class TreeNode3 {
     int val;
     TreeNode3 left;
      TreeNode3 right;
    TreeNode3() {}
      TreeNode3(int val) { this.val = val; }
      TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
       this.val = val;
         this.left = left;
          this.right = right;
      }
  }