package com.hyqTestForWork.Feb.Day6.Q3;

/**
 * @ClassName SearchMatrix
 * @Description TODO  240. 搜索二维矩阵 II  频度 medium
 * @Author huangyq
 * @Date 2022/2/6 16:34
 * @Version
 **/
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }

        int row = matrix.length-1;
        int column=0;

        while(row>=0&&column<matrix[0].length){
            int temp = matrix[row][column];
            if(temp>target){
                row-=1;
            }else if(temp<target){
                column+=1;
            }else{
                return true;
            }
        }

        return false;
    }
}
