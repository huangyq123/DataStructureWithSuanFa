package com.hyqTestForWork.Feb.Day5.Q1;

/**
 * @ClassName DifferencePath
 * @Description TODO  62. 不同路径  频度 medium
 * @Author huangyq
 * @Date 2022/2/5 20:33
 * @Version
 **/
public class DifferencePath {
    //经典回溯法——会出现超时
    public int uniquePaths(int m, int n){

        int result = 0;
        result = dfs(m,n,0,0,0);

        return result ;
    }

    public int dfs(int m,int n,int row, int column,int num){

        if(row==m-1&&column==n-1){
            return num+1;
        }
        int result = num;
        if(row<m-1){
            result = dfs(m,n,row+1,column,num);
        }
        if(column<n-1){
            result = dfs(m,n,row,column+1,result);
        }

        return result;
    }

    //动态规划
    public int uniquePaths2(int m, int n){

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=1;i<dp.length;i++){
            dp[i][0] = dp[i-1][0];
        }
        for(int i=1;i<dp[0].length;i++){
            dp[0][i] = dp[0][i-1];
        }

        for(int s=1;s<dp.length;s++){
            for(int t=1;t<dp[0].length;t++){
                dp[s][t] = dp[s-1][t] + dp[s][t-1];
            }
        }

        return dp[m-1][n-1];
    }
}
