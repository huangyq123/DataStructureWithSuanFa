package com.hyqTestForWork.Feb.Day3.Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName IsMore
 * @Description TODO  169. 多数元素  频度 medium     229. 求众数 II  频度 medium
 * @Author huangyq
 * @Date 2022/2/3 21:30
 * @Version
 **/
public class IsMore {
    //方法1：哈希表——直接遍历存储， 然后判断  不写

    //方法二——推广的摩尔投票法
    //这个方法的应用——求超过n/k 的 最多k-1个数
    //TODO 2.4
    public List<Integer> majorityElement(int[] nums){
        //设置k-1个数
        int[] num = new int[3-1];
        int[] count = new int[3-1];

        boolean isExist = false;
        boolean isEquals = false;
        for(int m=0;m<nums.length;m++){
            isExist = false;
            isEquals = false;
            //判断是否已经考虑位候选者
            for(int k=0;k<num.length;k++){
                if(num[k]==nums[m]){
                    count[k]+=1;
                    isEquals=true;
                    break;
                }
            }

            if(isEquals){
                continue;
            }
            //考虑候选者是否需要替换
            for(int k=0;k<num.length;k++){
                if(count[k]==0){
                    num[k] = nums[m];
                    count[k]+=1;
                    isExist=true;
                    break;
                }
            }

            if(isExist){
                continue;
            }
            //数量修改
            for(int k=0;k<num.length;k++){
                count[k]-=1;
            }

        }
        //遍历统计候选者个数
        Arrays.fill(count,0);
        for(int k=0;k<nums.length;k++){
            for(int m=0;m<num.length;m++){
                if(num[m]==nums[k]){
                    count[m]+=1;
                }
            }
        }
        //合并结果
        List<Integer> result = new ArrayList<>();
        for(int k=0;k<num.length;k++){
            if(count[k]>nums.length/3){
                result.add(num[k]);
            }
        }


        return result;
    }
}
