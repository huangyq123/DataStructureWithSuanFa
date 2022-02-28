package com.hyqTestForWork.Feb.Day20.Q1;

/**
 * @ClassName SortColor
 * @Description TODO  75. 颜色分类  频度 medium
 * @Author huangyq
 * @Date 2022/2/20 19:05
 * @Version
 **/
public class SortColor {
    //对撞指针——
    public void sortColors(int[] nums){


        int indexOfStart = extracted(nums, 0, nums.length - 1,0);
        if(indexOfStart<nums.length-1){
            //可能不需要进行第二次对撞处理
            extracted(nums,indexOfStart,nums.length-1,1);
        }

        return ;
    }

    private int extracted(int[] nums, int low, int high,int num) {
        while(high >= low){
            if(nums[high]!=num){
                high--;
                continue;
            }

            if(nums[low]==num){
                low++;
                continue;
            }

            int temp = nums[high];
            nums[high]= nums[low];
            nums[low]=temp;
            low++;
            high--;
        }
        return low;
    }


    //TODO  一次遍历+标记以及查找完的数组位置
}
