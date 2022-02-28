package com.hyqTestForWork.Feb.Day4.Q3;

import org.junit.Test;

/**
 * @ClassName StartAndEnd
 * @Description TODO  34. 在排序数组中查找元素的第一个和最后一个位置  频度 medium
 * @Author huangyq
 * @Date 2022/2/4 11:02
 * @Version
 **/
public class StartAndEnd {
    //细节上存在bug，调了一会——需要学习二分的实现细节
    public int[] searchRange(int[] nums, int target){

        int[] result = new int[]{-1,-1};
        if(nums==null||nums.length==0){
            return result;
        }
        if(target<nums[0]||target>nums[nums.length-1]){
            return result;
        }

        int start = binarySearch(nums, target, 0, nums.length - 1);
        int end = binarySearch2(nums, target, 0, nums.length - 1);

        if(start+1==end){
            return result;
        }else{
            result[0] = start+1;
            result[1] = end-1;
        }

        return  result;
    }

    public int binarySearch(int[] nums, int target,int start,int end){

        int medium = 0;
        while(start<=end){
//            if(start==end){
//                if(nums[end]==target){
//                    end-=1;
//                }
//                break;
//            }

            medium = start + (end-start)/2;
            if(nums[medium]>=target){
                end = medium-1;
            }else if(nums[medium]<target){
                start = medium+1;
            }
        }

        return end;
    }

    public int binarySearch2(int[] nums, int target,int start,int end){

        int medium = 0;
        while(start<=end){
//            if(start==end){
//                if(nums[start]==target){
//                    start+=1;
//                }
//                break;
//            }
            medium = start + (end-start)/2;
            if(nums[medium]>target){
                end = medium-1;
            }else if(nums[medium]<=target){
                start = medium+1;
            }
        }

        return start;
    }

    //TODO 复用的形式

    @Test
    public void Test(){
        int[] test = new int[]{5,7,7,8,8,10};
        searchRange(test,6);
    }
}
