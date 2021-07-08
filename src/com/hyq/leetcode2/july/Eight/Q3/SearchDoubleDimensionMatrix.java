package com.hyq.leetcode2.july.Eight.Q3;

/**
 * @ClassName SearchDoubleDimensionMatrix
 * @Description TODO  搜索二维数组
 * @Author huangyq
 * @Date 2021/7/8 17:42
 * @Version
 **/
public class SearchDoubleDimensionMatrix {

    //思路——利用二维数组特性进行简化搜索过程，每一次减小矩阵大小
    // 由于向右向下递增，则考虑向上向右搜索或者向下向左搜索；这样保证一个方向数值在减小，一个方向在增加；每次查找后如果不是目标值则可以排除一行\一列。
    //技巧：保证两个方向的变化趋势不一样，一个变小，一个变大
    public boolean searchMatrix(int[][] matrix, int target) {

        int row= matrix.length-1;
        int column=0;
        boolean result=false;
        while(row< matrix.length&&row>=0&&column>=0&&column<matrix[0].length){
            //进行向右上查找
            //如果比目标值大，则可排除当前所在的行
            if(matrix[row][column]>target){
                row--;
            }
            //如果比目标值小，则可以排除当前所在的列
            else if(matrix[row][column]<target){
                column++;
            }else {
                result=true;
                break;
            }
        }

        return result;
    }
}
