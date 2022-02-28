package com.hyqTestForWork.Janu.Day29.Q3;

/**
 * @ClassName MinPathSum
 * @Description TODO 64. 最小路径和  频度 medium
 * @Author huangyq
 * @Date 2022/1/29 19:32
 * @Version
 **/
public class MinPathSum {

    //思路一  dp
    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];

        for(int i=1;i<grid.length;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }

        for(int i=1;i<grid[0].length;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        for(int m=1;m<grid.length;m++){
            for(int n=1;n<grid[0].length;n++){
                dp[m][n] = Math.min(dp[m-1][n]+grid[m][n],dp[m][n-1]+grid[m][n]);
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
