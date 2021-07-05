package com.hyq.day15;

import java.util.ArrayList;

/**
 * @ClassName MaxValueInQueue
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/14 7:32
 * @Version
 **/
public class MaxValueInQueue {

ArrayList<Integer> queue;
int pointLow ;
int pointHigh ;
int max ;
    public MaxValueInQueue() {
        queue = new ArrayList<>();
        pointLow= -1;
        pointHigh = -1;
        max = -1;
    }

    public int max_value() {
        return max;
    }

    public void push_back(int value) {
        queue.add(value);
        if(queue.size()==1){
            pointLow++;
            pointHigh++;
            max = queue.get(pointHigh);
        }else{
            pointHigh++;
            if(queue.get(pointHigh)>max)
                max = queue.get(pointHigh);
        }
    }

    public int pop_front() {
        if(pointLow<0)
            return -1;
        if(pointLow>pointHigh)
            return -1;

        int result = queue.get(pointLow++);
        if(pointLow>pointHigh){
            max = -1;
            return result;
        }

        if(result>=max) {
            max = queue.get(pointLow);
            for (int k = pointLow + 1; k <= pointHigh; k++)
                max = Math.max(queue.get(k), max);
        }
        return result;
    }
}
