package com.hyq.day12;

/**
 * @ClassName DigitTranlateToString
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/10 14:14
 * @Version
 **/
public class DigitTranslateToString {


    static int count = 0;

    //递归问题+方向性（青蛙跳台阶）
    public static int translateNum(int num) {
        String s = Integer.toString(num);
        int[] list = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            list[i] = s.charAt(i) - 48;
        }
        Recur(list, 0);
        return count;
    }

    public static void Recur(int[] nums, int position) {
        if (position > nums.length - 1) {   //倒数第二位切割两位，走到末尾
            count++;
            return;
        }
        if (position == nums.length - 1) {   //走到倒数第一位
            count++;
            return;
        }

        Recur(nums, position + 1);  //一位

        if (nums[position] == 1 || (nums[position] == 2 && nums[position + 1] < 6)) {   //两位
            Recur(nums, position + 2);
        }

        return;
    }

    public static void main(String[] args) {
        translateNum2(25);
        System.out.println(count);
    }


//动态规划的写法、实现思路
    public static int translateNum2(int num) {
        String s = Integer.toString(num);
        int[] list = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            list[i] = s.charAt(i) - 48;
        }

        int[] dp = new int[s.length()+1];

        dp[0] = 1;
        dp[1] = 1;
        int k = 2;
        while (k < dp.length) {
            int temp = list[k-1] + list[k - 2]*10;
            if (temp >= 10 && temp < 26)
                dp[k] = dp[k - 1] + dp[k - 2];
            else
                dp[k] = dp[k - 1];
            k++;
        }

        return dp[dp.length-1];

    }
}
