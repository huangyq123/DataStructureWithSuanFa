package com.hyqTestForWork.Feb.Day17.Q2;

import java.util.Stack;

/**
 * @ClassName Temperature
 * @Description TODO  739. 每日温度  频度 medium
 * @Author huangyq
 * @Date 2022/2/17 19:41
 * @Version
 **/
public class Temperature {
    //单调栈——对于每一个位置，其实是找大于他的第一个值；那么维持一个非增序列，每当出现比他大的值就处理这个元素——单调栈
    //TODO _需要掌握单调栈的判断——什么情况使用？？
    public int[] dailyTemperatures(int[] temperatures){

        int[] result = new int[temperatures.length];

        Stack<Integer> temperature = new Stack<>();
        Stack<Integer> index = new Stack<>();
        temperature.push(temperatures[0]);
        index.push(0);
        int currentPosition = 1;
        while(currentPosition<temperatures.length){
            int temp = temperatures[currentPosition];
            if(!temperature.isEmpty()) {
                if (temperature.peek() < temp) {
                    temperature.pop();
                    int indexOfNow = index.pop();
                    result[indexOfNow] = currentPosition - indexOfNow;
                    continue;
                }
            }
            temperature.push(temp);
            index.push(currentPosition);
            currentPosition++;
        }

        return result;
    }
}
