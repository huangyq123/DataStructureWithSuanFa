package com.hyqTestForWork.March.Day1.Q2;

import org.junit.Test;

/**
 * @ClassName ZeroMatrix
 * @Description TODO  73. 矩阵置零  medium
 * @Author huangyq
 * @Date 2022/3/1 16:07
 * @Version
 **/
public class ZeroMatrix {
    //思路——使用标记数组进行记录，记录每一行、列是否存在0，有则修改该行、列；
    public void setZeroes(int[][] matrix) {
        int[] memory = new int[matrix.length+matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int k=0;k<matrix[0].length;k++){
                if(matrix[i][k]==0){
                    memory[i]=1;
                    memory[matrix.length+k]=0;
                }
            }
        }

        for(int m=0;m<matrix.length;m++){
            if(memory[m]==1){
                for(int n=0;n<matrix[0].length;n++){
                    matrix[m][n]=0;
                }
            }
        }

        for(int k=matrix.length;k< memory.length;k++){
            if(memory[k]==1){
                for(int s=0;s<matrix.length;s++){
                    matrix[s][k- matrix.length]=0;
                }
            }
        }

    }

    //TODO  优化 ：两个标记+第一行列做标记
    public void setZeroes2(int[][] matrix){
        int rowZero = 1;
        int columnZero = 1;

        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                columnZero=0;
                break;
            }
        }

        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                rowZero = 0;
            }
        }

        for(int m=1;m<matrix.length;m++){
            for(int n=1;n<matrix[0].length;n++){
                if(matrix[m][n]==0){
                    matrix[0][n] = 0;
                    matrix[m][0] = 0;
                }
            }
        }

        for(int m=1;m<matrix.length;m++){
            for(int n=1;n<matrix[0].length;n++) {
                if (matrix[m][0] == 0||matrix[0][n]==0){
                    matrix[m][n]=0;
                }
            }
        }
        if(rowZero==0){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
        if(columnZero==0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }

    @Test
    public void Test(){
        int[][] test = new int[][]{{3,5,5,6,9,1,4,5,0,5},{2,7,9,5,9,5,4,9,6,8},{6,0,7,8,1,0,1,6,8,1},{7,2,6,5,8,5,6,5,0,6},{2,3,3,1,0,4,6,5,3,5},{5,9,7,3,8,8,5,1,4,3},{2,4,7,9,9,8,4,7,3,7},{3,5,2,8,8,2,2,4,9,8}};
        setZeroes2(test);
    }

}
