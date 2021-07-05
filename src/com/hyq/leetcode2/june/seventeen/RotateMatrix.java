package com.hyq.leetcode2.june.seventeen;

/**
 * @ClassName RotateMatrix
 * @Description TODO  旋转图像  48
 * @Author huangyq
 * @Date 2021/6/17 20:17
 * @Version
 **/
public class RotateMatrix {

    public static void rotate(int[][] matrix) {

        int memory = 0;

        int time=0;


            int count=0;
            while(time<matrix.length/2){
                 int left=time;
                 int right=matrix[0].length-time-1;
                 int up=time;
                 int down=matrix.length-time-1;

                int positionX=time;
                int positionY=time;
                int m=0;
                int temp=0;
                if(up==down){
                    break;
                }else if(count<matrix.length-1-2*time){

                    while(m==0){
                        if(positionY>right){
                            m=1;
                            positionY--;
                            positionX++;
                            up++;
                            break;
                        }
                        temp =  matrix[positionX][positionY];
                        matrix[positionX][positionY++]=memory;
                        memory = temp;
                    }
                    while(m==1){
                        if(positionX>down){
                            m=2;
                            positionX--;
                            positionY--;
                            right--;
                            break;
                        }
                        temp =  matrix[positionX][positionY];
                        matrix[positionX++][positionY]=memory;
                        memory = temp;
                    }
                    while(m==2){
                        if(positionY<left){
                            m=3;
                            positionY++;
                            positionX--;
                            down--;
                            break;
                        }
                        temp =  matrix[positionX][positionY];
                        matrix[positionX][positionY--]=memory;
                        memory = temp;
                    }
                    while(m==3){
                        if(positionX<up){
                            m=4;
                            positionY--;
                            positionX++;
                            left++;
                            break;
                        }
                        temp =  matrix[positionX][positionY];
                        matrix[positionX--][positionY]=memory;
                        memory = temp;

                    }

                    matrix[time][time]=memory;
                    memory=0;

                    count+=1;
                }else{
                    count=0;
                    time+=1;
                }

        }

    }//通过所有用例
    //过程中问题： 1.循环的终止条件没写全  2.对矩阵层数判断错误导致矩阵中出现了错误值  3.内部的while循环 赋值操作 和 坐标变化操作 顺序搞错  4.内外层旋转次数判断错误
    //优化点： while操作可以转换为方法
    //代码太暴力——看题解优化


    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] test2 = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(test);
        rotate(test2);
        System.out.println(1);
    }

}
