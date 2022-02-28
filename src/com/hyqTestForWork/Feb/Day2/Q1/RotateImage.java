package com.hyqTestForWork.Feb.Day2.Q1;

import org.junit.Test;

/**
 * @ClassName RotateImage
 * @Description TODO  48. 旋转图像  频度 medium
 * @Author huangyq
 * @Date 2022/2/2 18:59
 * @Version
 **/
public class RotateImage {
    //自己解法——按圈算需要旋转几圈；对于每一圈，计算四个边界并计算本次一次旋转需要处理的元素个数； 进行元素缓存，并按照边界和本次旋转的方向进行元素修改
    public void rotate(int[][] matrix){
        //计算需要旋转的圈数
        int circleLength = matrix.length;
        int numsOfCircle = (circleLength+1)/2;
        int isOdd = circleLength%2;
        //方向数组，记录边界值
        int[] direction = new int[4];
        int times = numsOfCircle;
        //每一圈进行处理
        while(numsOfCircle>0){
            //根据当前是那一圈来计算本意每一次边的旋转需要旋转的元素个数，按照奇偶分类
            int lengthOfArray = 0;
            if(isOdd==1){
                lengthOfArray = numsOfCircle*2-2;
            }else{
                lengthOfArray = numsOfCircle*2-1;
            }

            if(lengthOfArray==0){
                break;
            }
            //设置边界值和初始的替换值，memory记录当前被替换的元素，然后复制给assist保存，assist就是当前被替换的元素，也是下一次需要替换到新的行\列中的元素
            int[] assist = new int[lengthOfArray];
            int[] memory = new int[lengthOfArray];
            direction[0] = 0+times-numsOfCircle;
            direction[1] = 0+times-numsOfCircle;
            direction[2] = matrix[0].length-1-times+numsOfCircle;
            direction[3] = matrix.length-1-times+numsOfCircle;
            for(int i = 0;i<assist.length;i++){
                assist[i] = matrix[direction[3]-i][direction[0]];
            }
            //每一圈需要旋转四边，每一边进行assist的元素替换并记录元素
            //每一个方向使用不同的规则、并利用边界值进行位置计算
            for(int m = 0;m<4;m++){
                for(int n=0;n<lengthOfArray;n++){
                    if(m==0) {
                        memory[n] = matrix[direction[1]][direction[0] + n];
                        matrix[direction[1]][direction[0] + n] = assist[n];
                        assist[n] = memory[n];
                    }else if(m==1){
                        memory[n] = matrix[direction[1] + n][direction[2]];
                        matrix[direction[1] + n][direction[2]] = assist[n];
                        assist[n] = memory[n];
                    }else if(m==2){
                        memory[n] =  matrix[direction[3]][direction[2]-n];
                        matrix[direction[3]][direction[2]-n] = assist[n];
                        assist[n] = memory[n];
                    }else{
                        memory[n] = matrix[direction[3] - n][direction[0]];
                        matrix[direction[3] - n][direction[0]] = assist[n];
                        assist[n] = memory[n];
                    }
                }
            }

            numsOfCircle--;
        }

    }

    @Test
    public void Test(){
        int[][] test = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(test);
    }

    //TODO 按照元素替换的位置索引关系，计算一轮的位置变换，进行旋转
    /**
     *@Author huangyq
     *@Description TODO
     *@Date 2022/2/3 19:43
     *@Param
     *@return
     *@Version
     **/
    public void rotate2(int[][] matrix){
        int temp = 0;
        int length = matrix.length;
        for(int m=0;m<length/2;m++){
            for(int n=0;n<(length+1)/2;n++){
                temp = matrix[m][n];
                matrix[m][n] = matrix[length-1-n][m];
                matrix[length-1-n][m] = matrix[length-1-m][length-1-n];
                matrix[length-1-m][length-1-n] = matrix[n][length-1-m];
                matrix[n][length-1-m] = temp;
            }
        }
    }

    //TODO 建立翻转和旋转的关系，使用翻转代替旋转
    public void rotate3(int[][] matrix){
        int times = matrix.length/2;

        for(int i=0;i<times;i++){
            for(int m = 0;m<matrix.length;m++){
                int temp = matrix[i][m];
                matrix[i][m] = matrix[matrix.length-1-i][m];
                matrix[matrix.length-1-i][m] = temp;
            }
        }

        for(int m = 0;m<matrix.length-1;m++){
            for(int n=m+1;n<matrix.length;n++){
                int temp = matrix[m][n];
                matrix[m][n] = matrix[n][m];
                matrix[n][m] = temp;
            }
        }
    }
}
