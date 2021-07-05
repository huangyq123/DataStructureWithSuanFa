package com.hyq.leetcode.UnionFind.question3;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NumberOfIsland
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/15 18:32
 * @Version
 **/
public class NumberOfIsland {

    //并查集
//    public static int numIslands2(char[][] grid){
//        List<Integer> result = new ArrayList<>();
//
//        int row = grid.length;
//        int column = grid[0].length;
//        int count = 0;
//        int[] memory = new int[row*column];
//        for(int i = 0;i<memory.length;i++)
//            memory[i]=i;
//
//        for(int m =0;m<grid.length;m++){
//            for(int n = 0;n<grid[0].length;n++){
//                if(grid[m][n]=='1'){
//                    if(grid[m-1][n]=='1') Union((m-1)*column+n,m*column+n,memory);
//                    else if(grid[m][n-1]=='1') Union( m*column+n-1,m*column+n,memory);
//                    //else count+=1;
//                }
//            }
//        }
//    }
//
//    public static void Union(int p,int q,int[] memory){
//        int rootP = find(p,memory);
//        int rootQ=find(q,memory);
//        if(rootP==rootQ)
//            return ;
//
//        memory[rootP]=rootQ;
//    }
//
//    public static int find(int p,int[] memory){
//        while(memory[p]!=p){
//            memory[p]=memory[memory[p]];
//            p=memory[p];
//        }
//        return p;
//    }



    public static int numIslands(char[][] grid) {

//        char[][] memory = new char[grid.length+2][grid[0].length+2];
//        for(int m = 0;m<memory.length;m++){
//            memory[m][0]='0';
//            memory[m][memory[0].length-1]='0';
//        }
//        for(int n = 0;n<memory[0].length;n++){
//            memory[0][n]='0';
//            memory[memory.length-1][n]='0';
//        }
//        for(int m=0;m<grid.length;m++){
//            for(int n = 0;n<grid[0].length;n++){
//                memory[m+1][n+1]=grid[m][n];
//            }
//        }

        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count+=dfs(grid, i, j,flag);
            }
        }
        return count;
    }

    //问题：理清楚回溯的处理步骤，每一步的需求（写得太慢了，改了好几次）
    public static int dfs(char[][] memory, int i, int j,boolean[][] flag) {
        if (i < 0 || j < 0 || i >= memory.length || j >= memory[0].length||flag[i][j]==true)
            return 0;

        if (memory[i][j] == '0')
            return 0;


        flag[i][j]=true;
        dfs(memory, i - 1, j,flag);
        dfs(memory, i + 1, j,flag);
        dfs(memory, i, j - 1,flag);
        dfs(memory, i, j + 1,flag);
        memory[i][j]='0';
        flag[i][j]=false;
        return 1;
    }
}
