package com.hyqTestForWork.Janu.Day18.Q3;

import org.junit.Test;

/**
 * @ClassName SumString
 * @Description TODO 33 搜索旋转排序数组  频度 medium
 * @Author huangyq
 * @Date 2022/1/18 20:53
 * @Version
 **/
public class SearchArray {
    //思路有问题——看题解：
    public int search(int[] nums, int target) {

        if(target==nums[0]){
            return 0;
        }else if(target==nums[nums.length-1]){
            return nums.length-1;
        }else if(target>nums[nums.length-1]&&target<nums[0]){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int medium = left+(right-left)/2;

            if(nums[medium]==target){
                return medium;
            }else if(nums[medium]<target){
                if(target<=nums[right]&&target<nums[left]){
                    left=medium+1;
                }else if(target>nums[right]&&target>=nums[left]){
                    right=medium-1;
                }
            }else if(nums[medium]>target){
                if(target>=nums[left]&&target>nums[right]){
                    right=medium-1;
                }else if(target<nums[left]&&target<=nums[right]){
                    right=medium-1;
                }else if(target<nums[left]&&target<=nums[right]){

                }
            }
        }

        return -1;
    }

    //理解：时间复杂度要比 o(n)低 则是 o(logn)，则必定二分 —— 二分需要顺序数组，用于判断是否包含数 —— 如何获得顺序数组 —— 数组二分，其中一部分是顺序的则容易判断是否存在
    public int search2(int[] nums, int target){

        if(target==nums[0]){
            return nums[0];
        }else if(target==nums[nums.length-1]){
            return nums[nums.length-1];
        }else if(target>nums[nums.length-1]&&target<nums[0]){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int medium = left +(right-left)/2;

            if(target==nums[medium]){
                return nums[medium];
            }else{
                if(nums[medium]>=nums[left]){
                    if(target<nums[medium]&&target>=nums[left]){
                        right=medium-1;
                    }else{
                        left=medium+1;
                    }
                }else{
                    if(target>nums[medium]&&target<=nums[right]){
                        left=medium+1;
                    }else{
                        right=medium-1;
                    }
                }

            }
        }

        return -1;
    }
    @Test
    public void Test(){
        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        int i = search2(ints, 0);
        System.out.println(i);
    }
}
