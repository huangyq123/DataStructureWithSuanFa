package com.hyq.leetcode2.june.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName XuanZhuanMatrix
 * @Description TODO
 * @Author huangyq
 * @Date 2021/6/7 20:12
 * @Version
 **/
public class rotate_matrix {


    public static List<Integer> spiralOrder(int[][] matrix) {
        //判断矩阵合法性
        if(matrix==null){
            return null;
        }
        int rows=matrix.length;
        if(rows<=0) {
            return null;
        }
        int columns=matrix[0].length;
        if(columns<=0){
            return null;
        }

        //边界设置，当前行走方向设置
        int up = 0;
        int down = rows-1;
        int left = 0;
        int right = columns-1;
        int status = 0;

        //坐标设置
        int positionX=0;
        int positionY=0;
        List<Integer> result = new ArrayList<>();

        while(result.size()<rows*columns){
            //向右读取矩阵
            if(status==0){
                result.add(matrix[positionX][positionY]);
                if(positionY==right){
                    positionX++;
                    up++;
                    //换下一个方向
                    status=1;
                }else{
                    positionY++;
                }
            }
            //向下读取矩阵
            else if(status==1){
                result.add(matrix[positionX][positionY]);
                if(positionX==down){
                    positionY--;
                    right--;
                    status=2;
                }else{
                    positionX++;
                }
            }
            //向左读取矩阵
            else if(status==2){
                result.add(matrix[positionX][positionY]);
                if(positionY==left){
                    positionX--;
                    down--;
                    status=3;
                }else{
                    positionY--;
                }
            }
            //向上读取矩阵
            else if(status==3){
                result.add(matrix[positionX][positionY]);
                if(positionX==up){
                    positionY++;
                    left++;
                    status=0;
                }else{
                    positionX--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //int[][] test = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] test = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = spiralOrder(test);
        for(int i=0;i<integers.size();i++){
            System.out.print(integers.get(i)+"   ");
        }
    }

}
