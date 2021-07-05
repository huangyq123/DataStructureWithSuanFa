package com.hyq.leetcode.question4;

import java.util.*;

/**
 * @ClassName ThreeNumberSum
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/19 16:48
 * @Version
 **/
public class ThreeNumberSum {

    //优化
    public static List<List<Integer>> threeSum2(int[] nums){
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(nums==null)
            return null;
        if(nums.length==0)
            return result;

        QuickSort(nums,0,nums.length-1);
        HashSet<List<Integer>> memory = new HashSet<>();

        for(int k=0;k<nums.length;k++){
            if(nums[k]>0)
                break;
            if(k>0&&nums[k]==nums[k-1])
                continue;

            int target = 0-nums[k];
            int low = k+1;
            int high = nums.length-1;
            while(low<high){
                if((nums[low]+nums[high])==target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[k]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    if(!memory.contains(temp)) {          //重复变量判断——错误二
                        memory.add(temp);
                        result.add(temp);
                    }
                    low++;       //循环变量修改——错误一
                    high--;
                    while(low<high&&nums[low]==nums[low-1])
                        low++;
                    while(low<high&&nums[high]==nums[high+1])
                        high--;
                }
                else if((nums[low]+nums[high])<target)
                    low++;
                else
                    high--;
            }
        }
        return result;
    }

//
    //优化——减少查找次数：nums[k]>0
    //    —— 等于时指针移动；重复元素跳过；
    public static List<List<Integer>> threeSum(int[] nums){
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(nums==null)
            return null;
        if(nums.length==0)
            return result;

        QuickSort(nums,0,nums.length-1);
        HashSet<List<Integer>> memory = new HashSet<>();

        for(int k=0;k<nums.length;k++){
            int target = 0-nums[k];
            int low = k+1;
            int high = nums.length-1;
            while(low<high){
                if((nums[low]+nums[high])==target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[k]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    if(!memory.contains(temp)) {          //重复变量判断——错误二
                        memory.add(temp);
                        result.add(temp);
                    }
                    low++;       //循环变量修改——错误一
                }
                else if((nums[low]+nums[high])<target)
                    low++;
                else
                    high--;
            }
        }
        return result;
    }

    public static void QuickSort(int[] nums,int start,int end){
        if(start<end){
            int position = Partition(nums,start,end);
            QuickSort(nums,start,position-1);
            QuickSort(nums,position+1,end);
        }
    }

    public static int Partition(int[] nums,int start,int end){
        int base = nums[start];
        int left = start;
        int right = end;

        while(left<right){
            while(left<right&&nums[right]>=base)
                right--;
            while(left<right&&nums[left]<=base)
                left++;

            swap(nums,left,right);
        }
        swap(nums,start,left);
        return left;
    }

    public static void swap(int[] nums,int left, int right){
        int temp = nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3,0,-2,-1,1,2};
        System.out.println(threeSum(test));
    }
}
