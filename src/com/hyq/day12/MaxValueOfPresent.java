package com.hyq.day12;

/**
 * @ClassName MaxValueOfPresent
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/10 16:22
 * @Version
 **/
public class MaxValueOfPresent {


    //效率问题，走过许多无用路径
    static int max = 0;

    public static int getMaxValue(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0)
            return 0;

        int count = 0;
        PathNum(nums, 0, 0, count);
        return max;
    }

    public static void PathNum(int[][] nums, int row, int column, int count) {
        if (row < 0 || row > nums.length - 1 || column < 0 || column > nums[0].length - 1) {
            return;
        }

        count += nums[row][column];
        if (row == nums.length - 1 && column == nums[0].length - 1) {
            count += nums[row][column];
            if (count > max)
                max = count;
            count -= nums[row][column];
            return;
        }

        PathNum(nums, row + 1, column, count);
        PathNum(nums, row, column + 1, count);
        count -= nums[row][column];
        return;
    }


    //动态规划
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int[][] dp = new int[grid.length + 1][grid[0].length + 1];  //初始化
        for (int m = 1; m < dp.length; m++) {
            for (int n = 1; n < dp[0].length; n++) {
                if (dp[m][n - 1] > dp[m - 1][n])
                    dp[m][n] = dp[m][n - 1] + grid[m - 1][n - 1];     //状态更新
                else
                    dp[m][n] = dp[m - 1][n] + grid[m - 1][n - 1];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    //化动态规划
    public int maxValue2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

         //初始化
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if(m==0&&n==0)
                    continue;
                else if(m==0)
                    grid[m][n]+=grid[m][n-1];
                else if(n==0)
                    grid[m][n]+=grid[m-1][n];
                else{
                    if (grid[m][n - 1] > grid[m - 1][n])
                        grid[m][n]+= grid[m][n - 1] ;     //状态更新
                    else
                        grid[m][n] += grid[m - 1][n] ;
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
