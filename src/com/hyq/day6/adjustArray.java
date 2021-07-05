package com.hyq.day6;

/**
 * @ClassName adjustArray
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/3 13:52
 * @Version
 **/
public class adjustArray {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4};
        int[] result = exchange(test);
        System.out.println(result);
    }

//头尾双指针
    public static int[] exchange(int[] nums) {
        int point1 = 0;
        int point2 = nums.length - 1;

        while (point1 < point2) {
            while (point1<point2&&(nums[point1] & 1) == 1)
                point1++;

            while (point1<point2&&(nums[point2] & 1) == 0)
                point2--;

            swap(nums, point1, point2);
//            point1++;
//            point2--;   //优化
        }

        return nums;
    }

    public static void swap(int[] nums, int a, int b) {
        if(a==b)
            return ;
        nums[b] = nums[b] + nums[a];
        nums[a] = nums[b] - nums[a];
        nums[b] = nums[b] - nums[a];
    }


    //快慢指针




}
