package com.hyqTestForWork.Feb.Day15.Q3;

/**
 * @ClassName RotateArray
 * @Description TODO  59. 螺旋矩阵 II  频度 medium
 * @Author huangyq
 * @Date 2022/2/15 10:58
 * @Version
 **/
public class RotateArray {
    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];
        int num = 1;
        int direction = 0;
        int[][] position = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int row = 0;
        int column = 0;
        int[] side = new int[]{n-1,n-1,0,0};
        int[] add = new int[]{1,-1,-1,1};
        while(num<=n*n){
            result[row][column] = num;
            num++;
            if(direction==0){
                if(column==side[0]){
                    row +=position[1][0];
                    column +=position[1][1];
                    direction = 1;
                    side[3] +=1;
                }else{
                    row+=position[0][0];
                    column+=position[0][1];
                }
            }else if(direction==1){
                if(row==side[1]){
                    row +=position[2][0];
                    column +=position[2][1];
                    direction = 2;
                    side[0] -=1;
                }else{
                    row+=position[1][0];
                    column+=position[1][1];
                }
            }else if(direction==2){
                if(column==side[2]){
                    row +=position[3][0];
                    column +=position[3][1];
                    direction = 3;
                    side[1] -=1;
                }else{
                    row+=position[2][0];
                    column+=position[2][1];
                }
            }else if(direction==3){
                if(row==side[3]){
                    row +=position[0][0];
                    column +=position[0][1];
                    direction = 0;
                    side[2] +=1;
                }else{
                    row+=position[3][0];
                    column+=position[3][1];
                }
            }


        }

        return result;
    }

    //TODO 同类代码优化
    public int[][] generateMatrix2(int n){
        int[][] result = new int[n][n];
        int num = 1;
        int[][] position = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int row = 0;
        int column = 0;
        int[] side = new int[]{n-1,n-1,0,0};
        int[] add = new int[]{1,-1,-1,1};
        //更新点0：优化代码时的初始值
        int direction = 4;
        while(num<=n*n){
            result[row][column] = num;
            num++;

            //修改点1:判断值 —— column\row选择
            int temp = direction%2==0?column:row;
            //修改点2：使用的side\direction\position的索引
            int x = direction%4;
            int y = (direction+1)%4;
            int z = (direction-1)%4;
            if(temp==side[x]){
                row +=position[y][0];
                column +=position[y][1];
                direction += 1;
                //修改点3：边界更新值的索引
                side[z] +=add[x];
            }else{
                row+=position[x][0];
                column+=position[x][1];
            }
        }

        return result;
    }

    //todo  可选：内部循环方式简化
}
