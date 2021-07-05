package com.hyq.leetcode2.june.TwentyFour.Q1;

import java.util.Arrays;

/**
 * @ClassName DeleteToTwoSameString
 * @Description TODO  两个字符串的删除操作 583
 * @Author huangyq
 * @Date 2021/6/24 18:47
 * @Version
 **/
public class DeleteToTwoSameString {

    //static int[][] dp;

    public static int minDistance(String word1, String word2) {

        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] temp:dp){
            Arrays.fill(temp,-1);
        }

        int dp1 = dp(word1, word2, 0, 0, dp);

        int result= word1.length()+word2.length()-dp1*2;
        return result;
    }

    public static int dp(String s1,String s2,int i,int j,int[][] dp){
        if(i>=s1.length()||j>=s2.length()) {
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }


        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j]=1+dp(s1,s2,i+1,j+1,dp);

        }else {
            dp[i][j]=Math.max(dp(s1,s2,i+1,j,dp),dp(s1,s2,i,j+1,dp));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        int i = minDistance("sea", "eat");
        System.out.println(i);
    }


}
