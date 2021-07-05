package com.hyq.leetcode2.july.Four.Q3;

/**
 * @ClassName LengthOfTarget
 * @Description TODO    34  排序数组中查找目标值的起始和结束位置
 * @Author huangyq
 * @Date 2021/7/4 17:42
 * @Version
 **/
public class LengthOfTarget {
    //典型思想：使用二分法查找边界——重点：处理当medium的值等于target的情况
    public static int[] searchRange(int[] nums, int target) {

        if(nums.length<1||target<nums[0]||target>nums[nums.length-1]){
            return new int[]{-1,-1};
        }

        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int medium = left+(right-left)/2;
            if(nums[medium]>target){
                right=medium-1;
            }else if(nums[medium]<target){
                left=medium+1;
            }else{
                if((medium+1)<nums.length&&!(nums[medium + 1] > target)){
                    left=medium+1;
                }else{
                    left=medium+1;
                    break;
                }
            }
        }
        int end=left;

        left=0;
        right=nums.length-1;
        while(left<=right){
            int medium = left+(right-left)/2;
            if(nums[medium]>target){
                right=medium-1;
            }else if(nums[medium]<target){
                left=medium+1;
            }else{
                if((medium-1)>=0&&!(nums[medium - 1] < target)){
                    right=medium-1;
                }else{
                    right=medium-1;
                    break;
                }
            }
        }
        int start=right;

        if(end-start==1){
            return new int[]{-1,-1};
        }else{
            return new int[]{start+1,end-1};
        }
    }

    //优化
    public static int[] searchRange2(int[] nums, int target) {

        if(nums.length<1||target<nums[0]||target>nums[nums.length-1]){
            return new int[]{-1,-1};
        }

        int left=0;
        int right=nums.length-1;

        int end=search(left,right,target,nums,true);

        left=0;
        right=nums.length-1;
        int start=search(left,right,target,nums,false);

        if(end-start==1){
            return new int[]{-1,-1};
        }else{
            return new int[]{start+1,end-1};
        }
    }

    public static int search(int left, int right,int target,int[] nums,boolean flag){
        while(left<=right){
            int medium = left+(right-left)/2;
            if(nums[medium]>target){
                right=medium-1;
            }else if(nums[medium]<target){
                left=medium+1;
            }else{
                if(flag) {
                    left = medium + 1;
                    if ((medium + 1) >=nums.length ||(nums[medium + 1] > target)){
                        break;
                    }
                }
                else{
                    right=medium-1;
                    if((medium-1)<0||(nums[medium - 1] < target)){
                        break;
                    }
                }
            }
        }

        if(flag){
            return left;
        }else{
            return right;
        }
    }


    public static void main(String[] args) {
        int[] ints = searchRange2(new int[]{1}, 1);
        System.out.println(1);
    }
}
