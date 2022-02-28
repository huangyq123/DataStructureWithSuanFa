package com.hyqTestForWork.Feb.Day5.Q2;

/**
 * @ClassName SortReverseArray
 * @Description TODO  153. 寻找旋转排序数组中的最小值  频度 medium
 * @Author huangyq
 * @Date 2022/2/5 20:48
 * @Version
 **/
public class SortReverseArray {
    //二分实现，但是逻辑还是有点乱，需要理一理
    //需要回顾二分细节
    public int findMin(int[] nums) {
        if(nums==null){
            return -1;
        }
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }

        int result = findSortTarget(nums, 0, nums.length - 1);

        return result;
    }

    public int findSortTarget(int[] nums,int start,int end){
        if(start==end){
            return start;
        }else if(end-1==start){
            return nums[end]>nums[start]?start:end;
        }

        int medium = start;
        while(start<end){
            medium = start + (end-start)/2;
            int temp = nums[medium];
            if(temp>nums[start]){
                if(temp<nums[end]) {
                    return findSortTarget(nums, start,medium );
                }else{
                    return findSortTarget(nums, medium + 1, end);
                }
            }
//            else if(temp<nums[end]){
//                if(temp>nums[start]) {
//                    return findSortTarget(nums, start, medium);
//                }else{
//                    return findSortTarget(nums, medium + 1, end);
//                }
//            }
        }

        return  -1;
    }

    //TODO  梳理完逻辑的二分  2.6  迭代型
}
