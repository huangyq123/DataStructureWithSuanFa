package com.hyqTestForWork.Janu.Day23.Q2;

import java.util.Arrays;

/**
 * @ClassName NextPailie
 * @Description TODO 31. 下一个排列 频度 medium
 * @Author huangyq
 * @Date 2022/1/23 19:55
 * @Version
 **/
public class NextPailie {
    //大思路清楚，细节上不熟悉
    //  具体解法—— 从右边开始找到一个数A，保证他的右边有比它大的数；  找到这个数A后，把A和 他右边的比他大的数中的最小数B进行交换， 再从A的原位置开始，把他右边的数升序排列
    public void nextPermutation(int[] nums){

        if(nums==null||nums.length<=1){
            return ;
        }

        int index1 = nums.length-2;
        int index2 = nums.length-1;
        int max = nums[nums.length-1];
        int min = -1;

        //[1,3,2]
        while(index1>=0){
            //注意等于号位置，等于不能够保证右边有比它大的数，因此需要继续找
            if(nums[index1]>=max){
                max = nums[index1];
                index1--;
            }else{
                break;
            }
        }

        int index3 = index1;
        if(index1>=0){
            index2 = index1+1;
            min = max+1;
            while(index2<nums.length){
                if(nums[index2]<min&&nums[index2]>nums[index1]){
                    min = nums[index2];
                    index3 = index2;
                }
                index2++;
            }

            int temp = nums[index1];
            nums[index1] = nums[index3];
            nums[index3] = temp;

            //交换后需要排序
            Arrays.sort(nums,index1,nums.length);
        }else{
            Arrays.sort(nums);
        }


    }

    //TODO  算法优化——两次遍历+双指针反转序列排序；和上面算法本质一般，但是对规律更清晰  1.24
}
