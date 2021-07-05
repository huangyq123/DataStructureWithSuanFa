package com.hyq.day10;

import java.util.HashMap;

/**
 * @ClassName PastHalfNumber
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/8 20:38
 * @Version
 **/
public class PastHalfNumber {

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int result = majorityElement2(test);
        System.out.println(1);
    }

    //摩尔投票法
    public static int majorityElement3(int[] nums) {
        int votes = 0;          //当前众数票数
        int temp = 0;            //当前众数

        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {          //当前面的众数统计票数为0，忽略前面部分，对后面的数组进行统计
                temp = nums[i];
                votes++;
            } else {
                if (nums[i] == temp)            //票数统计
                    votes++;
                else
                    votes--;
            }
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {  //验证是否存在众数
            if (nums[i] == temp)
                count++;
        }

        if (count > nums.length / 2)
            return temp;
        else
            return -1;
    }


    //排序（快排思想）查找第K大数
    public static int majorityElement2(int[] nums) {
        int position = nums.length / 2;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int temp = partition(nums, start, end);
            if (temp == position)
                break;
            if (temp > position) end = temp - 1;
            if (temp < position) start = temp + 1;
        }
        return nums[position];
    }

    public static int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int low = start;
        int high = end;

        while (low < high) {
            while (low < high && nums[high] >= base)//等号？
                high--;
            while (low < high && nums[low] <= base)
                low++;
            swap(nums, low, high);
        }
        swap(nums, start, low);
        return low;
    }

    public static void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }


    //hashmap实现，
    public int majorityElement(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> memory = new HashMap<>();
        int length = nums.length / 2;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            if (memory.containsKey(temp))
                continue;

            for (int k = i; k < nums.length; k++) {
                if (nums[k] == temp)
                    count++;
            }

            if (count > length)
                break;

            memory.put(temp, count);
            count = 0;
        }

        return temp;
    }
}
