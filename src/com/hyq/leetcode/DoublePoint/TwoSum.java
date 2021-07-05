package com.hyq.leetcode.DoublePoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName TwoSum
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/1 12:15
 * @Version
 **/
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {

//        List<Integer> var= new ArrayList<>();
//        Stream<Integer> stream = var.stream();
//        stream.reduce(0,(x,y)->x+y);
//        //stream.reduce()
//        stream.collect();
//        Collectors.toCollection();

        int low = 0;
        int high = numbers.length-1;
        int[] result = new int[2];
        while(low<high){
            int temp = numbers[low]+numbers[high];
            if(temp>target)
                high--;
            else if(target>temp)
                low++;
            else
            {
                result[0]=low+1;
                result[1]=high+1;
                break;
            }
        }
        return result;



    }
}
