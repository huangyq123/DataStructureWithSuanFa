package com.hyq.leetcode2.june.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SumOfThreeNumber
 * @Description TODO   三数之和 15
 * @Author huangyq
 * @Date 2021/6/8 19:41
 * @Version
 **/
public class SumOfThreeNumber {

    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length<3){
            return result;
        }

        int position_1 = 0;
        int position_2 = 1;
        int position_3 = nums.length-1;

        Arrays.sort(nums);
      //  List<List<Integer>> result = new ArrayList<>();

        while(position_1<nums.length-1){
            //定住第一个数

            while(position_2<position_3){

                //存在查找区间时
                int temp = nums[position_1]+nums[position_2]+nums[position_3];

                if(temp<0){
                    //数值偏小
                    position_2++;
                }else if( temp>0){
                    //数值偏大
                    position_3--;
                }else{
                    //数值正好符合
                    List<Integer> objects = new ArrayList<>();
                    objects.add(nums[position_1]);
                    objects.add(nums[position_2]);
                    objects.add(nums[position_3]);
                    result.add(objects);
                    //查找下一个组合
                    if((position_2+1)>=nums.length){
                        //已经查找完毕
                        break;
                    }
                    while((position_2+1)<nums.length&&nums[position_2]==nums[position_2+1]){
                        //让第二个数进行变化
                        position_2++;
                    }
                    position_2++;
                }
            }
            //查找下一个组合
            if((position_1+1)>=nums.length-2){
                //已经查找完毕
                break;
            }
            while((position_1+1)<nums.length&&nums[position_1]==nums[position_1+1]){
                //让第二个数进行变化
                position_1++;
            }
            position_1++;
            position_2 = position_1+1;
            position_3 = nums.length-1;
        }
        return result;
    }

    public static void main(String[] args) {
       //int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums=new int[]{0,0,0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(1);
    }

}
