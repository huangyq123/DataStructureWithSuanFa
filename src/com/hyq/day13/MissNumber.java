package com.hyq.day13;

/**
 * @ClassName MissNumber
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/11 16:36
 * @Version
 **/
public class MissNumber {

//边界终止条件理清楚
    public static int missingNumber(int[] nums) {
        if (nums == null)
            return -1;
        if (nums.length == 0)
            return 0;

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int medium = (i + j) / 2;
            if (nums[medium] > medium) j = medium - 1;
            else i = medium + 1;
        }
        if (i > nums.length - 1)
            return nums.length;
        else
            return nums[i] - 1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0};
        int result = missingNumber(test);
        System.out.println(result);
    }
}
