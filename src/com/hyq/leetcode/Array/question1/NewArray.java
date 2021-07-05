package com.hyq.leetcode.Array.question1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @ClassName NewArray
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/14 20:13
 * @Version
 **/
public class NewArray {
    static HashMap<Integer,Integer> memory = new LinkedHashMap<>();
    static ArrayList<Integer> body = null;
    //static int count = 0;

    /** Initialize your data structure here. */
    public NewArray() {
        body = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if(!memory.containsKey(val)){
            memory.put(val,body.size());
            body.add(val);
            return true;
        }else
            return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(memory.containsKey(val)){
            int leftIndex = memory.get(val);
            int rightValue = body.get(body.size()-1);
            body.set(leftIndex,rightValue);
            body.remove(body.size()-1);
            memory.put(rightValue,leftIndex);
            memory.remove(val);
            return true;
        }else
            return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int temp = (int)(Math.random()*body.size());
        return body.get(temp);
    }

}
