package com.hyqTestForWork.Janu.Day12.Q3;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName ThreeSum
 * @Description TODO  15  三树之和  频度  medium
 * @Author huangyq
 * @Date 2022/1/12 20:30
 * @Version
 **/
public class ThreeSum {

    //以前版本-2021.6.8
    public List<List<Integer>> threeSum2(int[] nums) {
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
                //让第一个数进行变化
                position_1++;
            }
            position_1++;
            position_2 = position_1+1;
            position_3 = nums.length-1;
        }
        return result;
    }

    //2022.1.12——见题解写的
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length<3){
            return result;
        }

        Arrays.sort(nums);

        int lastFirst = nums[0]-1;
        int lastSecond = nums[0]-1;
        int lastThird = nums[0]-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==lastFirst){
                continue;
            }
            int tempSum = 0-nums[i];
            for(int j=i+1,k=nums.length-1;j<k;){
                lastSecond=nums[j];
                lastThird=nums[k];
                if(nums[j]+nums[k]==tempSum){
                    ArrayList<Integer> tempResult = new ArrayList<>();
                    tempResult.add(nums[i]);
                    tempResult.add(nums[j]);
                    tempResult.add(nums[k]);
                    result.add(tempResult);

                    lastSecond=nums[j];
                    lastThird=nums[k];
                    while(j<k&&nums[j]==lastSecond){
                        j++;
                    }
                }else if(nums[j]+nums[k]>tempSum){
                    while(k>j&&nums[k]==lastThird){
                        lastThird=nums[k];
                        k--;
                    }
                }else if(nums[j]+nums[k]<tempSum){
                    while(j<k&&nums[j]==lastSecond){
                        lastSecond=nums[j];
                        j++;
                    }
                }
            }
            lastFirst=nums[i];

        }

        return result;
    }

    @Test
    public void Test(){
        int[] test = new int[]{-1,0,1,2,-1,-4};
        threeSum(test);
    }

}
