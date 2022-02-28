package com.hyqTestForWork.Janu.Day20.Q2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RotateMatrix
 * @Description TODO 54  螺旋矩阵 频度 medium
 * @Author huangyq
 * @Date 2022/1/20 15:53
 * @Version
 **/
public class RotateMatrix {
    //模拟法
    public List<Integer> spiralOrder(int[][] matrix){

        //方向数组
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        //边界数组
        int[][] change = new int[][]{{1,-1,1,0,0,0},{-1,-1,0,0,0,-1},{-1,1,0,-1,0,0},{1,1,0,0,1,0}};
        List<Integer> result = new ArrayList<>();

        dfs(matrix,result,direction,0,change,0,0,0, matrix.length-1,0,matrix[0].length-1);
        return result;
    }

    public void dfs(int[][] matrix,List<Integer> result,int[][] direction,int index,int[][] change, int row,int column,int up,int down,int left,int right){
        if(left>right||up>down){
            return ;
        }

        while(row>=up&&row<=down&&column>=left&&column<=right){
            result.add(matrix[row][column]);
            row+=direction[index][0];
            column+=direction[index][1];
        }
        //注意方向使用的数组位置和边界使用的数组位置区别
        int temp = (index + 1) % 4;
        dfs(matrix, result, direction, temp,change,row+change[index][0],column+change[index][1],up+change[index][2],down+change[index][3],left+change[index][4],right+change[index][5] );

        return ;

    }

    @Test
    public void Test(){
        int[][] test = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(test);

    }

}
