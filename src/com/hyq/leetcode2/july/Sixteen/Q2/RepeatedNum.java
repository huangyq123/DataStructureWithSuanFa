package com.hyq.leetcode2.july.Sixteen.Q2;

/**
 * @ClassName RepeatedNum
 * @Description TODO   287.寻找重复数
 * @Author huangyq
 * @Date 2021/7/16 19:46
 * @Version
 **/
public class RepeatedNum {
    //思路——使用二分法来查找。  当某个数 x 出现重复，包含x在内的范围中数的个数大于范围宽度，否则小于等于。  根据结果可以知道重复数在哪一个区间，不断二分直到最后一个数就是目标值。
    public static int findDuplicate(int[] nums) {
        int length = nums.length;
        int count=0;
        int left=1;
        int right=nums.length-1;

        while(left<right){
            int medium=(right-left)/2+left;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=medium){
                    count++;
                }
            }

            if(count<=medium){
                left=medium+1;
            }else if(count>medium){
                right=medium;
            }
            count=0;
        }
        return left;
    }

    public static void main(String[] args) {
        int duplicate = findDuplicate(new int[]{3,1,3,4,2});
        System.out.println(duplicate);
    }
}
