package com.hyqTestForWork.Feb.Day6.Q4_7;

/**
 * @ClassName fINDsQUARE
 * @Description TODO  221. 最大正方形  pindu  medium
 * @Author huangyq
 * @Date 2022/2/6 17:53
 * @Version
 **/
public class fINDsQUARE {

    //TODO  题解法： 核心——朴素解法是遍历所有位置进行统计，而中间的一些状态可以被复用来获取信息，因此考虑dp；  dp的核心是定义状态和转移方程
    public int maximalSquare(char[][] matrix){

        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0]=='1'?1:0;
        int max = dp[0][0];
        for(int i=1;i<dp.length;i++){
            dp[i][0]=matrix[i][0]=='1'?1:0;
            max = Math.max(max,dp[i][0]);
        }
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=matrix[0][i]=='1'?1:0;
            max = Math.max(max,dp[0][i]);
        }

        for(int m=1;m<dp.length;m++){
            for(int n=1;n<dp[0].length;n++){
                if(matrix[m][n]=='1'){
                    dp[m][n] = Math.min(dp[m-1][n],Math.min(dp[m][n-1],dp[m-1][n-1]))+1;
                    max = Math.max(max,dp[m][n]);
                }
            }
        }

        return max*max;
    }

    //TODO  上次自己的解法——dp的另一种实现  2.7/2.8
    public int maximalSquare2(char[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0]=='1'?1:0;
        int max = dp[0][0];
        for(int i=1;i<dp.length;i++){
            dp[i][0]=matrix[i][0]=='1'?1:0;
            max = Math.max(max,dp[i][0]);
        }
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=matrix[0][i]=='1'?1:0;
            max = Math.max(max,dp[0][i]);
        }

        for(int m=1;m<dp.length;m++){
            for(int n=1;n<dp[0].length;n++){
                if(matrix[m][n]=='1'){
                    int length = dp[m-1][n-1];
                    int tempLength = 1;
                    for(int i=1;i<=length;i++){
                        if(matrix[m-i][n]!='1'||matrix[m][n-i]!='1'){
                            break;
                        }
                        tempLength+=1;
                    }
                    dp[m][n] = tempLength;
                    max = Math.max(tempLength,max);
                }
            }
        }

        return max*max;
    }
}
