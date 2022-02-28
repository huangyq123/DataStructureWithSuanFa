package com.hyqTestForWork.Janu.Day8.Q2;

/**
 * @ClassName ClimbStairs
 * @Description TODO  70 爬楼梯 hot100 easy
 * @Author huangyq
 * @Date 2022/1/8 20:33
 * @Version
 **/
public class ClimbStairs {
    //递归实现
    public int climbStairs(int n) {


        int result=dfs(n);

        return result;
    }

    public int dfs(int n){
        if(n<0){
            return 0;
        }
        if(n==1||n==0){
            return 1;
        }
        return dfs(n-1)+dfs(n-2);
    }

    //动态规划实现
    public int climbStairs2(int n) {
//        int[] memory = new int[n+1];
//        memory[0]=1;
//        memory[1]=1;
//
//        for(int i=2;i<memory.length;i++){
//            memory[i]=memory[i-1]+memory[i-2];
//        }
//
//        return memory[n];

        //空间优化
        int[] memory = new int[2];
        memory[0]=1;
        memory[1]=1;

        for(int i=2;i<=n;i++){
            int temp = memory[1];
            memory[1]=memory[0]+memory[1];
            memory[0]=temp;
        }

        return memory[1];
    }


    //快速幂计算——1.9任务
    public int climbStairs3(int n){

        int[][] matrix = new int[][]{{1,1},{1,0}};
        int[][] tempMatrix = matrixPow(matrix, n-1);
        //构造初始向量
        int[] initial=new int[]{1,1};
        //返回乘积结果
        return tempMatrix[0][0]*initial[0]+tempMatrix[0][1]*initial[1];
    }

    public int[][] matrixPow(int[][] matrix,int n){
        //注意初ret始值
        int[][] ret = new int[][]{{1,0},{0,1}};
        int times=n;
        while(times>0){
            if((times&1)==1){
                //加权乘积
                ret=multiply(ret,matrix);
            }
            times=times>>1;
            //基底构造
            matrix=multiply(matrix,matrix);
        }

        return ret;
    }

    public int[][] multiply(int[][] matrix,int[][] matrix2){
        int[][] temp = new int[matrix.length][matrix[0].length];

        for(int m=0;m<matrix.length;m++){
            for(int n=0;n<matrix[0].length;n++){
                temp[m][n]=matrix[m][0]*matrix2[0][n]+matrix[m][1]*matrix2[1][n];
            }
        }

        return temp;
    }

    //递推公式——可以考虑，一般不太用，可能存在浮点数误差
}
