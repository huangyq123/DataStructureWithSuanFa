package com.hyqTestForWork.Janu.Day9.Q6;

/**
 * @ClassName OnlyOnceElement
 * @Description TODO 136 只出现一次的数字  hot100  easy
 * @Author huangyq
 * @Date 2022/1/9 13:44
 * @Version
 **/
public class OnlyOnceElement {
    //不适用额外空间的实现——异或运算——这类解法的场景？？
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            result^=nums[i];
        }

        return result;
    }
}
