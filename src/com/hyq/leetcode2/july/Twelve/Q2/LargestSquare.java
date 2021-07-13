package com.hyq.leetcode2.july.Twelve.Q2;

/**
 * @ClassName LargestSquare
 * @Description TODO   221 最大正方形
 * @Author huangyq
 * @Date 2021/7/12 19:49
 * @Version
 **/
public class LargestSquare {
    public static int maximalSquare(char[][] matrix) {
        int rows=matrix.length;
        int column=matrix[0].length;

        int[][] dp=new int[rows][column];
        int length=0;
        for(int i=0;i<column;i++){
            dp[0][i]=matrix[0][i]=='1'?1:0;
            length=Math.max(length,dp[0][i]);
        }

        for(int i=0;i<rows;i++){
            dp[i][0]=matrix[i][0]=='1'?1:0;
            length=Math.max(length,dp[i][0]);
        }


        for(int i=1;i<rows;i++){
            for(int j=1;j<column;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }
                else if(dp[i-1][j-1]==0){
                    dp[i][j]=1;
                }else{
//                    boolean flag=true;
                    int extra=0;
                    for(int m=1;m<=dp[i-1][j-1];m++){
                        if(matrix[i-m][j]=='0'||matrix[i][j-m]=='0'){
                            break;
                        }
                        extra+=1;
                    }

                    dp[i][j]=extra+1;

                }
                length=Math.max(length,dp[i][j]);
            }
        }

        return length*length;
    }

    public static void main(String[] args) {
        int i = maximalSquare(new char[][]{{ '0','0','0', '1'}, {'1', '1','0', '1'}, {'1', '1', '1', '1'}, { '0', '1', '1','1'},{'0','1','1','1'}});
        System.out.println(i);
    }
}
