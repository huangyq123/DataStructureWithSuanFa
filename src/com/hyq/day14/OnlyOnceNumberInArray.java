package com.hyq.day14;

/**
 * @ClassName OnlyOnceNumberInArray
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/12 9:24
 * @Version
 **/
public class OnlyOnceNumberInArray {


    public static int[] singleNumber(int[] nums) {
        int firstResult = nums[0];
        for (int i = 1; i < nums.length; i++)           //异或得到结果
            firstResult = firstResult ^ nums[i];

        int temp = 1;
        while ((temp & firstResult) != temp) {         //找1的位置      //位运算比较对象
            temp = temp << 1;
        }

        //可以不进行实际分组
        int pointLow = 0;
        int pointHigh = nums.length - 1;
        while (pointLow < pointHigh) {            //分组
            while (pointLow < pointHigh && (nums[pointHigh] & temp) == temp)
                pointHigh--;
            while (pointLow < pointHigh && (nums[pointLow] & temp) != temp) //索引和元素不要混
                pointLow++;
            swap(nums, pointLow, pointHigh);
        }

        int[] result = new int[]{nums[0],nums[pointHigh+1]};    //双指针指向最后一个0
        for(int k = 1;k<=pointLow;k++){
            result[0] = result[0]^nums[k];
        }
        for(int m = pointHigh+2;m<nums.length;m++){
            result[1] = result[1]^nums[m];
        }

        return result;
    }

    public static void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,5,2};
        int[] result = singleNumber(test);
        System.out.println(result);
    }
}
