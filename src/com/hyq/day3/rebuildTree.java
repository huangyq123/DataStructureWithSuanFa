package com.hyq.day3;

import javax.swing.tree.TreeNode;

/**
 * @ClassName rebuildTree
 * @Description TODO
 * @Author huangyq
 * @Date 2021/2/26 7:34
 * @Version
 **/
public class rebuildTree {

    public static void main(String[] args) {
//        int[] a = new int[]{1,2,4,7,3,5,6,8};
//        int[] b = new int[]{4,7,2,1,5,3,8,6};
        //不完全二叉树

//        int[] a1 = new int[]{1,2,4,5,3,6,7};
//        int[] b1 = new int[]{4,2,5,1,6,3,7};
        //完全二叉树

//        int[] a2 = new int[]{1,2,4,5};
//        int[] b2 = new int[]{1,2,4,5};
        //无左节点

//        int[] a3 = new int[]{1};
//        int[] b3 = new int[]{1};
        //单节点

        int[] a4 = new int[]{1,2,4,7,3,5,6,8};
        int[] b4 = new int[]{4,7,2,1,5,9,8,6};
        treeNode t = build(a4, b4);
        //reConstructBinaryTree2(a4, b4)

        out(t);//构建结果测试

//遍历测试
//        treeNode treeNode = new treeNode();
//        treeNode.Value = 1;
//        treeNode.LeftNode=new treeNode();
//        treeNode.LeftNode.Value=2;
//        treeNode.RightNode = new treeNode();
//        treeNode.RightNode.Value=3;
       // out(treeNode);

        //遍历测试
//        int[] a1 = new int[]{10,6,4,8,14,12,16};
//        int[] b1 = new int[]{4,6,8,10,12,14,16};
//        treeNode t1 = build(a1, b1);
//        out(t1);
    }





public static treeNode build(int[] array1,int[] array2){
    if(array1==null||array2==null||array1.length==0||array2.length==0){
        return null;
    }
    else
        return  rebuild(array1,array2,0,array2.length-1,0);
}

    /**
     *@Author huangyq
     *@Description TODO    利用前序遍历和中序遍历递归构建二叉树
     *                     问题：边界条件的位置不合理，增加了不必要的判断次数；
     *                          建立右子树时的索引值逻辑不清晰；
     *                          递归地实现不够熟练
     *@Date 2021/2/26 8:52
     *@Param [array1, array2, start, end, index]
     *@return com.hyq.day3.treeNode
     *@Version
     **/
    public static treeNode rebuild(int[] array1,int[] array2,int start, int end,int index){

        if(start==end){
            treeNode tn = new treeNode();
            tn.Value=array1[index];
            tn.LeftNode=null;
            tn.RightNode=null;
            return tn;
        }else{
            int a = array1[index];
            int location = find(array2,a);
            treeNode t = new treeNode();
            t.Value = a;
            if(location>start){
                t.LeftNode = rebuild(array1,array2,start,location-1,index+1);
            }
            if(location<end){
                t.RightNode = rebuild(array1,array2,location+1,end,index+location-start+1);
            }
            return t;
        }

    }
/**
 *@Author huangyq
 *@Description TODO   辅助函数，用于查找索引
 *@Date 2021/2/26 9:27
 *@Param [array, number]
 *@return int
 *@Version
 **/
    public static int find(int[] array,int number){
        int position = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==number)
                position=i;
        }
        return position;
    }

/**
 *@Author huangyq
 *@Description TODO   遍历方法，用于测试重建二叉树是否正确
 *@Date 2021/2/26 9:26
 *@Param [n]
 *@return void
 *@Version
 **/
    public static void out(treeNode n){
        System.out.println(n.Value);//前序遍历
        if(n.LeftNode!=null){
            treeNode tt = new treeNode();
            tt=n.LeftNode;
            out(tt);
        }
        //System.out.println(n.Value);//中序遍历
        if(n.RightNode!=null){
            treeNode tt = new treeNode();
            tt=n.RightNode;
            out(tt);
        }
        //System.out.println(n.Value);//后序遍历
    }

/**
 *@Author huangyq
 *@Description TODO  书本样例  时间复杂度：O(n)，空间复杂度：O(n)
 *                   区别：结束递归条件不同；
 *@Date 2021/2/26 9:33
 *@Param [preorder, inorder]
 *@return javax.swing.tree.TreeNode
 *@Version
 **/
    public static  treeNode reConstructBinaryTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 ||
                inorder == null || inorder.length == 0) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.
                length - 1);
    }

    public static treeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int rootVal = preorder[preL];
        int index = 0;
        while (index <= inR && inorder[index] != rootVal) {
            index++;
        }
        treeNode root = new treeNode();
        root.Value = rootVal;
        root.LeftNode = helper(preorder, preL + 1, preL - inL + index, inorder,
                inL, index);
        root.RightNode = helper(preorder, preL - inL + index + 1, preR, inorder,
                index + 1, inR);
        return root;
    }
}


