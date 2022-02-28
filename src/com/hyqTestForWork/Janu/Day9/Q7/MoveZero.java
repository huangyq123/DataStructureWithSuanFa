package com.hyqTestForWork.Janu.Day9.Q7;

import org.junit.Test;

/**
 * @ClassName MoveZero
 * @Description TODO  283  移动零  hot100 easy
 * @Author huangyq
 * @Date 2022/1/9 14:14
 * @Version
 **/
public class MoveZero {
    public void moveZeroes(int[] nums) {

        int pointZero = 0;
        int pointElse = 0;
        while(pointElse<nums.length&&pointZero<nums.length){
            while(pointZero<nums.length&&nums[pointZero]!=0){
                pointZero++;
            }
            if(pointZero>=nums.length){break;}

            while(pointElse<nums.length&&(nums[pointElse]==0||pointElse<=pointZero)){
                pointElse++;
            }
            if(pointElse>=nums.length){break;}

            int temp = nums[pointElse];
            nums[pointElse]=0;
            nums[pointZero]=temp;
            pointZero++;
            pointElse++;
        }
    }

    @Test
    public void Test(){
        int[] test =new int[]{0,1,0,3,12};
        moveZeroes(test);
        System.out.println(1);
    }
}
