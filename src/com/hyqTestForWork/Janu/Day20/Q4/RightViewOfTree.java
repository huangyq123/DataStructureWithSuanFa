package com.hyqTestForWork.Janu.Day20.Q4;


import java.util.*;

/**
 * @ClassName rIGHTvIEWoFtREE
 * @Description TODO  199  二叉树右视图  频度 medium
 * @Author huangyq
 * @Date 2022/1/20 20:01
 * @Version
 **/
public class RightViewOfTree {
    //dfs遍历，递归形式
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root==null){
            return result;
        }
        Set<Integer> memory = new HashSet<>();
        //通过层数标记判断是否需要加入正在搜索的节点
        search(root,result,memory,0);

        return result;
    }

    public int search(TreeNode root, List<Integer> result,Set<Integer> memory, int layers){

        if(root==null){
            return 0;
        }
        //通过层数判断当前层节点是否已有，有则忽略当前节点
        if(!memory.contains(layers)){
            result.add(root.val);
            memory.add(layers);
        }
        //继续搜索下层节点
        search(root.right,result,memory,layers+1);
        search(root.left,result,memory,layers+1);

        return -1;
    }

    //TODO DFS 迭代形式

    //bfs遍历
    public List<Integer> rightSideView2(TreeNode root){

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            result.add(queue.peekLast().val);
            int length = queue.size();
            for(;length>0;length--){
                TreeNode temp = queue.pollFirst();
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
        }

        return result;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
