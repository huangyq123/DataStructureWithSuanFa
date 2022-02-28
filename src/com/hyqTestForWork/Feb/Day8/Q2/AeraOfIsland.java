package com.hyqTestForWork.Feb.Day8.Q2;

import com.hyq.leetcode2.june.test;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName AeraOfIsland
 * @Description TODO  695. 岛屿的最大面积  频度 meidum
 * @Author huangyq
 * @Date 2022/2/8 20:50
 * @Version
 **/
public class AeraOfIsland {
    //经典回溯dfs
    public int maxAreaOfIsland(int[][] grid) {

        int result = 0;
        for(int m=0;m<grid.length;m++){
            for(int n=0;n<grid[0].length;n++){
                if(grid[m][n]==1) {
                    int area = dfs(grid, m, n, 0);
                    result = Math.max(result,area);
                }
            }
        }

        return result;
    }

    public int dfs(int[][]grid,int row, int column,int area){
        if(row>=grid.length||row<0||column>=grid[0].length||column<0){
            return area;
        }

        if(grid[row][column]!=1) {
            return area;
        }
        area+=1;
        //注意修改状态的时间，为了保证其他方向的搜索不会重复搜索当前节点，应该先修改状态
        grid[row][column] = 0;
        area = dfs(grid, row - 1, column, area);
        area = dfs(grid, row + 1, column, area);
        area = dfs(grid, row , column - 1, area);
        area = dfs(grid, row , column + 1, area);


        return area;
    }

    //TODO  BFS 2.9
    //注意更新原矩阵状态的时间点
    public int maxAreaOfIsland2(int[][] grid){
        int result = 0;
        Queue<Integer> memory = new LinkedList<>();
        for(int m=0;m<grid.length;m++){
            for(int n=0;n<grid[0].length;n++){
                int tempArea = 0;
                if(grid[m][n]==1) {
                    memory.add(m);
                    memory.add(n);
                    grid[m][n]=0;
                    while(!memory.isEmpty()){
                        tempArea+=1;
                        Integer row = memory.poll();
                        Integer column = memory.poll();
                        if(row-1>=0&&grid[row-1][column]==1){
                            memory.add(row-1);
                            memory.add(column);
                            grid[row-1][column]=0;
                            //如果取出再更新会导致被重复加入，因此要在加入时就进行更新
                        }
                        if(row+1<grid.length&&grid[row+1][column]==1){
                            memory.add(row+1);
                            memory.add(column);
                            grid[row+1][column]=0;
                        }
                        if(column-1>=0&&grid[row][column-1]==1){
                            memory.add(row);
                            memory.add(column-1);
                            grid[row][column-1]=0;
                        }
                        if(column+1<grid[0].length&&grid[row][column+1]==1){
                            memory.add(row);
                            memory.add(column+1);
                            grid[row][column+1]=0;
                        }

                    }
                }
                result = Math.max(result,tempArea);
            }
        }

        return result;
    }

    @Test
    public void test(){
        int[][] test = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        maxAreaOfIsland2(test);
    }

}
