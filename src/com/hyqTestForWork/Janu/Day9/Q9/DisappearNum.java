package com.hyqTestForWork.Janu.Day9.Q9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DisappearNum
 * @Description TODO  448 数组中消失的数字  hot100 easy
 * @Author huangyq
 * @Date 2022/1/9 18:41
 * @Version
 **/
public class DisappearNum {
    //原地算法进行修改——还是使用了额外空间进行值交换的辅助
    //原地算法注意点——交换的值是哪两个；  是否会重复交换导致数组变回原来的结果；  什么时候往前推进
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i=0;i<nums.length;i++){
            //保证这个位置的值不在变动才结束；否则可能会导致应该交换到该位置的值没有被交换
            while(nums[nums[i]-1]!=nums[i]){
                int temp = nums[i];
                nums[i]=nums[nums[i]-1];
                nums[temp-1]=temp;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                result.add(i+1);
            }
        }

        return result;
    }


    //题解：不需要辅助的原地算法

    @Test
    public void Test(){
        List<Integer> disappearedNumbers = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        for(int i:disappearedNumbers){
            System.out.println(i+"");
        }
    }
}
