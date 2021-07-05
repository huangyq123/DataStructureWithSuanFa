package com.hyq.leetcode.question10;

/**
 * @ClassName SearchRangeOfNumberInArray
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/22 19:37
 * @Version
 **/
public class SearchRangeOfNumberInArray {
    public static int[] searchRange(int[] nums, int target){
        if(nums==null||nums.length==0)
            return new int[]{-1,-1};

        int[] result = new int[2];
        int left = 0;
        int right = nums.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target)
                right = mid;
            else if(nums[mid]<target)
                left = mid+1;
            else
                right = mid;
        }

        if(left>=nums.length||nums[left]!=target){
            result[0]=-1;
            result[1]=-1;
            return result;
        }
        result[0] = left;

        left = 0;
        right = nums.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target)
                right = mid;
            else if(nums[mid]<target)
                left = mid+1;
            else
                left = mid+1;
        }
        result[1] = right-1;

        return result;
    }




    public static void main(String[] args) {
        int[] test = new int[]{1};
        int[] ints = searchRange(test, 0);
        System.out.println(ints[0]+"    "+ints[1]);
    }
}
