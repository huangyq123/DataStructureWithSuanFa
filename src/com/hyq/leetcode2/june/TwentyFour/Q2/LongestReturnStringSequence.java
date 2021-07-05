package com.hyq.leetcode2.june.TwentyFour.Q2;

import java.util.Arrays;

/**
 * @ClassName LongestReturnStringSequence
 * @Description TODO
 * @Author huangyq
 * @Date 2021/6/24 19:27
 * @Version
 **/
public class LongestReturnStringSequence {

    //思路一：转化为最长子序列
    public static int longestPalindromeSubseq(String s) {

        StringBuffer stringBuffer = new StringBuffer();
        for(int i =s.length()-1;i>=0;i--){
            stringBuffer.append(s.charAt(i));
        }
        String s2= stringBuffer.toString();


        int[][] dp=new int[s.length()][s.length()];
        for(int[] temp:dp){
            Arrays.fill(temp,-1);
        }

        int dp1 = dp(s, s2, 0, 0, dp);

        return dp1;
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

    //思路二：直接使用动态规划
    //问题：注意初始化的值
    public static int longestPalindromeSubseq2(String s){
        int[][] dp=new int[s.length()][s.length()];
        for(int[] temp:dp){
            Arrays.fill(temp,-1);
        }
        for(int i=1;i<s.length();i++){
            dp[i][i-1]=0;
        }
        int dp1 = dp(s, 0, s.length()-1, dp);

        return dp1;
    }

    public static int dp(String s,int i,int j,int[][] dp){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=dp(s,i+1,j-1,dp)+2;
        }else{
//            int dp1 = dp(s, i + 1, j, dp);
//            int dp2 = dp(s, i, j - 1, dp);
            dp[i][j]=Math.max(dp(s, i + 1, j, dp),dp(s, i , j-1, dp));
        }
        return dp[i][j];
    }


    public static void main(String[] args) {
        int i = longestPalindromeSubseq2("abceddfebb");
        System.out.println(i);
    }
}
