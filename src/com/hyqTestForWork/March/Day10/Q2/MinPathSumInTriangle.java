package com.hyqTestForWork.March.Day10.Q2;

import java.util.List;
import java.util.Stack;

/**
 *@Author admin
 *@Description TODO  120. 三角形最小路径和  medium
 *@Date 2022/3/10 17:54
 *@Param
 *@return
 *@Version
 **/

public class MinPathSumInTriangle {
    //注意点：List本质上还是数组，可以使用索引遍历，因此这里可以不用使用栈，直接进行修改
    // 面试时需要注意能不能修改原数组的要求；
    public int minimumTotal(List<List<Integer>> triangle) {

        Stack<List<Integer>> memory = new Stack<>();

        for(int i=0;i<triangle.size();i++){
            memory.push(triangle.get(i));
        }

        List<Integer> temp = memory.pop();

        while(!memory.isEmpty()){
            List<Integer> pop1 = memory.pop();
            for(int m=0;m<pop1.size();m++){
                int newValue = Math.min(temp.get(m),temp.get(m+1));
                pop1.set(m,pop1.get(m)+newValue);
            }
            temp = pop1;
        }


        return temp.get(0);
    }

    //修改——不用栈
    public int minimumTotal3(List<List<Integer>> triangle) {

        int index =triangle.size()-1;

        while(index>0){
            for(int i=0;i<triangle.get(index-1).size();i++) {
                int temp = Math.min(triangle.get(index).get(i),triangle.get(index).get(i+1));
                triangle.get(index - 1).set(i,triangle.get(index-1).get(i)+temp);
            }
        }


        return triangle.get(0).get(0);
    }

    //TODO  动态规划
    public int minimumTotal2(List<List<Integer>> triangle){

        int[] memory = new int[triangle.size()];
        int[] memory2 = new int[triangle.size()];
        memory[0] = triangle.get(0).get(0);

        int result = Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++){
            int[] array1 = memory;
            int[] array2 = memory2;
            if(i%2==0){
                array1 = memory2;
                array2 = memory;
            }
            array2[0] = array1[0]+triangle.get(i).get(0);
            int length =triangle.get(i).size()-1;
            for(int m=1;m<length;i++){
                array2[i] = Math.min(array1[i],array1[i-1])+triangle.get(i).get(i);
            }
            array2[length] = array1[length-1]+triangle.get(i).get(length);
        }



        return -1;
    }
}
