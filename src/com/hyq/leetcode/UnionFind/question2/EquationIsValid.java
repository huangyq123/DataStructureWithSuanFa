package com.hyq.leetcode.UnionFind.question2;

/**
 * @ClassName EquationIsValid
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/15 16:22
 * @Version
 **/
public class EquationIsValid {

    //并查集
    public static boolean equationsPossible(String[] equations) {

        int[] memory = new int[26];
        int[] size = new int[26];
        for(int k = 0;k< memory.length;k++){
            memory[k]=k;
            size[k]=1;
        }                             //建立并初始化父节点数组、树节点个数数组

        char left = '0';
        char right = '0';
        char isEqual = '0';

        for(int i = 0;i<equations.length;i++){                  //遍历等式
            String temp = equations[i];
            isEqual = temp.charAt(1);
            if('!'==isEqual)
                continue;

            left = temp.charAt(0);
            right = temp.charAt(3);

            Union((int)(left-'a'+0),(int)(right-'a'+0),memory,size);        //将所有相等变量都连接到同一棵树

        }

        for(int i = 0;i<equations.length;i++) {          //遍历不等式
            String temp = equations[i];
            isEqual = temp.charAt(1);
            if ('!' != isEqual)
                continue;

            left = temp.charAt(0);
            right = temp.charAt(3);

            if(connected((int)(left-'a'+0),(int)(right-'a'+0),memory))         //如果不等式中的变量在同一棵树则说明无法成立
                return false;
        }
        return true;
    }

    public static void Union(int p,int q,int[] memory,int[] size){    //将节点 “并” 到一棵树
        int rootP = find(p,memory);                     //查找节点 P 的树的根节点
        int rootQ = find(q,memory);                     //查找节点 Q 的树的根节点
        if(rootP==rootQ)
            return ;

        if(size[rootP]>size[rootQ]){                //考虑平衡性，将小树接到大树
            memory[rootQ]=rootP;
            size[rootP]+=size[rootQ];
        }else{
            memory[rootP]=rootQ;
            size[rootQ]+=size[rootP];
        }
    }

    public static int find(int p,int[] memory){                //查找根节点
        while(memory[p]!=p){
            memory[p]=memory[memory[p]];
            p = memory[p];
        }
        return p;
    }

    public static boolean connected(int p,int q,int[] memory){      //判断是否在同一棵树
        int rootP = find(p,memory);
        int rootQ = find(q,memory);
        return rootP==rootQ;
    }
}
