package com.hyqTestForWork.March.Day3.Q1;

import org.junit.Test;

/**
 *@Author admin
 *@Description TODO  72. 编辑距离  hard
 *@Date 2022/3/3 21:30
 *@Param
 *@return
 *@Version
 **/
public class EditDistance {
    //todo  重写——这里是看题解写的
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0] = i;
        }
        for(int m=0;m<dp[0].length;m++){
            dp[0][m] = m;
        }

        for(int m=1;m<dp.length;m++){
            for(int n=1;n<dp[0].length;n++){
                if(word1.charAt(m-1)==word2.charAt(n-1)) {
                    dp[m][n] = Math.min(Math.min(dp[m - 1][n] + 1, dp[m][n - 1] + 1), dp[m - 1][n - 1]);
                }else{
                    dp[m][n] = Math.min(Math.min(dp[m - 1][n] + 1, dp[m][n - 1] + 1), dp[m - 1][n - 1]+1);
                }
            }
        }

        System.out.println(1);
        return dp[word1.length()-1][word2.length()-1];
    }

    @Test
    public void Test(){
        minDistance("horse","ros");
    }
}
