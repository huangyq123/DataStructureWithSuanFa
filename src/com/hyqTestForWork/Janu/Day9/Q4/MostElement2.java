package com.hyqTestForWork.Janu.Day9.Q4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MostElement2
 * @Description TODO  229  求众数2  medium
 * @Author huangyq
 * @Date 2022/1/9 11:59
 * @Version
 **/
public class MostElement2 {

    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp = nums[i];
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }else{
                map.put(temp,1);
            }
        }

        List<Integer> result=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>nums.length/3){
               result.add(entry.getKey());
            }
        }
        return result;

    }

    //摩尔投票法_不是很理解，需要再理解_这里写的是通用形式，对任意个众数都可以使用
    public List<Integer> majorityElement2(int[] nums){
        int[] count=new int[]{0,0};
        int[] major=new int[2];

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int temp = nums[i];
            boolean flag=false;
            for(int m=0;m<2;m++){
                if(temp==major[m]){
                    count[m]+=1;
                    flag=true;
                    break;
                }
            }

            if(flag){
                continue;
            }

            for(int m=0;m<2;m++){
                if(count[m]==0){
                    count[m]+=1;
                    major[m]=temp;
                    flag=true;
                    break;
                }
            }

            if(flag){
                continue;
            }

            for(int m=0;m<2;m++){
               count[m]-=1;
            }
        }

        for(int t=0;t<count.length;t++){
            count[t]=0;
        }
        for(int k=0;k<nums.length;k++){
            int tempValue = nums[k];
            for(int w=0;w<2;w++){
                if(nums[k]==major[w]){
                    count[w]+=1;
                    break;
                }
            }
        }

        for(int y=0;y<major.length;y++){
            if(count[y]>nums.length/3){
                result.add(major[y]);
            }
        }
        return result;
    }

    @Test
    public void Test(){
        List<Integer> integers = majorityElement2(new int[]{2, 1, 1, 3, 1, 4, 5, 6});
        for(Integer in:integers){
            System.out.println(in+" ");
        }
    }
}
