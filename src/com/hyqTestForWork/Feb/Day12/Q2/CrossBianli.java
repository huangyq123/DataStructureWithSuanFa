package com.hyqTestForWork.Feb.Day12.Q2;

/**
 * @ClassName CrossBianli
 * @Description TODO  498. 对角线遍历 频度 medium
 * @Author huangyq
 * @Date 2022/2/12 16:52
 * @Version
 **/
public class CrossBianli {
    public int[] findDiagonalOrder(int[][] mat) {

        int direction = 0;
        int[] result = new int[mat.length*mat[0].length];

        int row = 0;
        int column = 0;
        int index = 0;
        while(index<result.length){
            if(direction==0){
                result[index] = mat[row][column];
                if(column+1>=mat[0].length){
                    row = row+1;
                    direction=1;
                }
                else if(row-1<0){
                    column = column+1;
                    direction=1;
                }else{
                    row = row-1;
                    column = column+1;
                }
                index++;
            }else{
                result[index] = mat[row][column];
                if(row+1>mat.length){
                    column = column+1;
                    direction=0;
                }else if(column+1>=mat[0].length){
                    row = row+1;
                    direction=0;
                }
                else{
                    row = row+1;
                    column = column-1;
                }
                index++;
            }
        }
        return result;
    }

    //TODO  类似代码简化
    public int[] findDiagonalOrder2(int[][] mat) {


        int[] result = new int[mat.length*mat[0].length];

        int row = 0;
        int column = 0;
        int index = 0;
        int[] ints = new int[3];
        while(index<result.length){
            if(ints[2]==0){
                result[index] = mat[ints[1]][ints[0]];
                ints = changePosition(column, row, mat[0].length, 0);
                index++;
            }else{
                result[index] = mat[ints[0]][ints[1]];
                ints = changePosition(row, column, mat.length, 1);
                index++;
            }
        }
        return result;
    }

    public int[] changePosition(int index1,int index2,int length,int direction){
        if(index1+1>=length){
            index2 = index2+1;
            direction=direction==0?1:0;
        }
        else if(index2-1<0){
            index1 = index1+1;
            direction=direction==0?1:0;
        }else{
            index2 = index2-1;
            index1 = index1+1;
        }
        return new int[]{index1,index2,direction};
    }

}
