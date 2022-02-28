package com.hyqTestForWork.Janu.Day19.Q1;

import org.junit.Test;

/**
 * @ClassName NumsOfIslands
 * @Description TODO  200 岛屿数量  频度 medium
 * @Author huangyq
 * @Date 2022/1/19 19:00
 * @Version
 **/
public class NumsOfIslands {
    //注意dfs时状态和递归的顺序——dfs解法
    public int numIslands(char[][] grid) {

        int result =0;

        for(int m=0;m<grid.length;m++){
            for(int n=0;n<grid[0].length;n++){
                if(grid[m][n]!='1'){
                    continue;
                }else{
                    result+=1;
                    dfs(grid,m,n);
                }
            }
        }

        return result;
    }

    public void dfs(char[][] grid,int row,int column){
        if(row<0||row>=grid.length||column<0||column>=grid[0].length){
            return ;
        }

        if(grid[row][column]=='0'){
            return ;
        }
        grid[row][column]='0';
        dfs(grid,row-1,column);
        dfs(grid,row+1,column);
        dfs(grid,row,column-1);
        dfs(grid,row,column+1);



        return ;
    }

    @Test
    public void Test(){
        char[][] test = new char[][]{{'1', '1', '1', '1', '0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int i = numIslands(test);
        System.out.println(i);
    }

    //广度优先——  1.20

}
