package com.hyqTestForWork.Janu.Day12.Q2;

import org.junit.Test;

/**
 * @ClassName QuickSort
 * @Description TODO 补充题4 手撕快排 频度 6  medium
 * @Author huangyq
 * @Date 2022/1/12 18:32
 * @Version
 **/
public class QuickSort {
    //递归形式快排——问题：注意while中两个flag判断——一开始用两个if，则可能出现都走一遍的情况，导致越界（一次应该只能走一个，要用else）；
    //                 注意最后的赋值索引，这里end必然没问题，应该有end（一开始使用start会出现问题——因为前一个问题没改，改了前一个应该都行；但是如果用<=判断则需要考虑索引）；
    public int[] sortArray(int[] nums) {

        QuickSort(nums,0,nums.length-1);

        return nums;
    }

    public void QuickSort(int[] nums,int left,int right){
        if(left>=right){
            return ;
        }
        int start=left;
        int end=right;

        int base=nums[start];
        int flag=0;
        while(start<end){
            if(flag==0) {
                if (nums[end] > base) {
                    end--;
                } else {
                    nums[start] = nums[end];
                    start++;
                    flag = 1;
                }
            }else if(flag==1){  //这里需要使用else保证一次直走一个方向，避免越界
                if(nums[start]<=base){
                    start++;
                }else{
                    nums[end]=nums[start];
                    end--;
                    flag=0;
                }
            }

        }
        //bug点1：根据while结束条件带不带=，选择不同的可能会产生问题
        nums[start]=base;
        QuickSort(nums,left,start-1);
        QuickSort(nums,start+1,right);

    }

    //迭代方式——不会写了  1.13任务  同时需要复习其他排序的实现
    public int[] sortArray2(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int medium = 0;
        while(start<end){
            medium = QuickSort2(nums, start, end);
        }

        return nums;
    }

    public int QuickSort2(int[] nums,int left,int right){
        if(left>=right){
            return right;
        }
        int start=left;
        int end=right;

        int base=nums[start];
        int flag=0;
        while(start<end){
            if(flag==0) {
                if (nums[end] > base) {
                    end--;
                } else {
                    nums[start] = nums[end];
                    start++;
                    flag = 1;
                }
            }else if(flag==1){  //这里需要使用else保证一次直走一个方向，避免越界
                if(nums[start]<=base){
                    start++;
                }else{
                    nums[end]=nums[start];
                    end--;
                    flag=0;
                }
            }

        }
        //bug点1：根据while结束条件带不带=，选择不同的可能会产生问题
        nums[start]=base;
        return start;

    }

    @Test
    public void Test(){
        int[] test = new int[]{-4,0,7,4,9,-5,-1,0,-7,-1};
        sortArray(test);
        for(int i:test){
            System.out.println(i+"");
        }
    }

}
