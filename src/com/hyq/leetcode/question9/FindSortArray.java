package com.hyq.leetcode.question9;

/**
 * @ClassName FindSortArray
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/22 18:32
 * @Version
 **/
public class FindSortArray {

    public static void main(String[] args) {
        int[] test = new int[]{1,3};
        int i = searchMain(test, 0);
        System.out.println(i);
    }

    public static int searchMain(int[] nums, int target) {
        if(nums == null||nums.length==0)
            return -1;

        int index = Recur(nums,0,nums.length-1);
        int result = -1;
        if(target >nums[nums.length-1]&&target<nums[0]){
            return result;
        }else if(target>nums[nums.length-1]){
            result = Search(nums,0,index-1,target);
        }else{
            result = Search(nums,index,nums.length-1,target);
        }
        return result;
    }

    //递归迭代写法
    public static int Recur(int[] nums,int start,int end){
        if(start>end)
            return start;
        if(start == end)
            return start;

        int medium = (start+end)/2;
        int result = 0;
        if(nums[medium]>nums[end]){       //判断条件
             result = Recur(nums,medium+1,end);
        }else if(nums[medium]<nums[end]){
            result = Recur(nums,start,medium);        //边界问题
        }

        return result;
    }

    public static int Search(int[] nums,int start,int end,int target){
        int result = -1;
        while(start<=end){
            int medium =(start+end)/2;
            if(nums[medium]<target)
                start = medium+1;
            else if(nums[medium]>target)
                end = medium-1;
            else{
                result = medium;
                break;
            }
        }
        return result;
    }

}
