package com.hyqTestForWork.Janu.Day9.Q3;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MostElement
 * @Description TODO  169  多数元素  hot100 easy
 * @Author huangyq
 * @Date 2022/1/9 11:30
 * @Version
 **/
public class MostElement {
    //基本算法实现
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp = nums[i];
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }else{
                map.put(temp,1);
            }
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>nums.length/2){
                return entry.getKey();
            }
        }
         return -1;
    }

    //排序——思路：排序完后 n/2的位置一定是众数    理解就行，不用实现

    //考虑空间复杂度的优化
    //摩尔投票法——理解：count=0将区间分为两段，右边的众数必定是原来的众数
    public  int majorityElement2(int[] nums){
        int count=0;
        int major=-1;

        for(int i=0;i<nums.length;i++){
            if(count==0){
                major=nums[i];
                count+=1;
            } else if(nums[i]==major){
                count+=1;
            }else if(nums[i]!=major){
                count-=1;
            }
        }

        return major;
    }
}
