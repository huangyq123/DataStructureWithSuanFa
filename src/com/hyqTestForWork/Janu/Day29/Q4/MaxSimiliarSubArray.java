package com.hyqTestForWork.Janu.Day29.Q4;

import org.junit.Test;

/**
 * @ClassName MaxSimiliarSubArray
 * @Description TODO  718. 最长重复子数组  频度 medium
 * @Author huangyq
 * @Date 2022/1/29 19:50
 * @Version
 **/
public class MaxSimiliarSubArray {
    //动态规划——状态表示以i结尾和以j结尾的两个相同字符串的匹配长度；
    public int findLength(int[] nums1, int[] nums2){

        int result = -1;
        int[][] dp = new int[nums1.length][nums2.length];

        dp[0][0] = nums1[0]==nums2[0]?1:0;

        for(int i=1;i<dp[0].length;i++){
            if(nums1[0]==nums2[i]){
                dp[0][i]=1;
            }else{
                dp[0][i]=0;
            }
        }

        for(int i=1;i<dp.length;i++){
            if(nums1[i]==nums2[0]){
                dp[i][0]=1;
            }else{
                dp[i][0]=0;
            }
        }

        for(int m=dp[0].length-1;m>=0;m--){
            int column = m;
            int row = 0;

            while(row+1<dp.length&&column+1<dp[0].length){
                dp[row+1][column+1] = nums1[row+1]==nums2[column+1]?dp[row][column]+1:0;
                result = Math.max(result,dp[row+1][column+1]);
                row++;
                column++;
            }
        }

        for(int n=1;n<dp.length;n++){
            int column = 0;
            int row = n;

            while(row+1<dp.length&&column+1<dp[0].length){
                dp[row+1][column+1] = nums1[row+1]==nums2[column+1]?dp[row][column]+1:0;
                result = Math.max(result,dp[row+1][column+1]);
                row++;
                column++;
            }
        }

        return result;
    }

    //TODO 滑动窗口


    @Test
    public void Test(){
        int[] test1 = new int[]{1,2,3,2,1};
        int[] test2 = new int[]{3,2,1,4,7};
    }

}
