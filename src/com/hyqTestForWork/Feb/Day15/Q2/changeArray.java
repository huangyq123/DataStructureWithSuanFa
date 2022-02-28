package com.hyqTestForWork.Feb.Day15.Q2;

/**
 * @ClassName changeArray
 * @Description TODO  剑指 Offer 21. 调整数组顺序使奇数位于偶数前面  频度 medium
 * @Author huangyq
 * @Date 2022/2/15 10:47
 * @Version
 **/
public class changeArray {
    //快慢双指针
    public int[] exchange(int[] nums) {
        if(nums==null||nums.length==0){
            return nums;
        }

        int slow = 0;
        int fast = 0;

        while(fast<nums.length){
            int temp = nums[fast];
            if(temp%2==1){
                swap(nums,slow,fast);
                slow++;
            }
            fast++;
        }

        return nums;
    }

    public void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    //TODO 数组划分，减少遍历次数、交换次数
}
