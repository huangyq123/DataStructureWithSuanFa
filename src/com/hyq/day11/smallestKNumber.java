package com.hyq.day11;

import java.util.Arrays;

/**
 * @ClassName smallestKNumber
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/9 8:51
 * @Version
 **/
public class smallestKNumber {


    //思路二：不修改数组
    //问题：使用场景、实现方式、优先队列
    public int[] getLeastNumbers2(int[] arr, int k){

        if(arr==null||k>arr.length)
            return null;
        if(k<=0)
            return new int[]{};

        int[] result = new int[k];
        int position = 0;

        for(int i =0;i<arr.length;i++){
            if(position<k){
                result[position] = arr[i];
                position++;
                continue;
            }
            Arrays.sort(result);              //应该替换为堆排序
            if(result[k-1]>arr[i])
                result[k-1]=arr[i];
        }

        return result;
    }



//思路一：快排处理
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null||k>arr.length)
            return null;

        int start =0;
        int end = arr.length-1;
        while(start<end){
            int temp = partition(arr,start,end);
            if(temp==k)  break;
            if(temp>k)  end = temp-1;
            if(temp<k)  start =temp+1;
        }

        return Arrays.copyOfRange(arr,0,k);//方法返回值
    }

    public static int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && nums[right] >= base)
                right--;
            while (left < right && nums[left] <= base)
                left++;

            swap(nums, left, right);
        }
        if (left != start)
            swap(nums, start, left);
        return left;
    }

    public static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
