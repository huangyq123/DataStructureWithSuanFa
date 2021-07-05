package com.hyq.day13;

import java.util.HashSet;

/**
 * @ClassName TimesCount
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/11 14:27
 * @Version
 **/
public class TimesCount {

    public static int search(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return 0;

        int[] result = HalfSearch(nums,target,0,nums.length-1);
        if(result[0]==0)
            return 0;

        int count =1;
        int point1 = result[1];
        int point2 = result[1];

        while(point1>0&&nums[point1-1]==target)
            point1--;
        while(point2<(nums.length-1)&&nums[point2+1]==target)
            point2++;

        return point2-point1+1;
    }

    public static int[] HalfSearch(int[] nums, int target, int start, int end) {
        if(start==end){
            if(nums[start]==target)
                return new int[]{1,start};
            else
                return new int[]{0,start};
        }

        int medium = (start + end) / 2;
        if (nums[medium] == target)
            return new int[]{1, medium};
        else if (nums[medium] < target)
            return HalfSearch(nums, target, medium + 1, end);
        else
            return HalfSearch(nums, target, start, medium);
    }


    public static void main(String[] args) {
        int[] test = new int[]{5,7,7,8,8,10};
        int result = search(test,6);
        System.out.println(result);
    }
}
