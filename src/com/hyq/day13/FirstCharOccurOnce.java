package com.hyq.day13;

import java.util.ArrayList;

/**
 * @ClassName FirstCharOccurOnce
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/11 9:36
 * @Version
 **/
public class FirstCharOccurOnce {


    //时间效率不高？——内置方法问题？
    //数据结构的选择？
    //数组建立哈希表的思想
    public char firstUniqChar(String s){
        if(s==null)
            return ' ';

        ArrayList<Character> memory = new ArrayList<>();
        ArrayList<Integer>   times = new ArrayList<>();

        for(int i =0;i<s.length();i++){
            char temp = s.charAt(i);
            if(memory.contains(temp)){
                int index = memory.indexOf(temp);
                times.set(index,times.get(index)+1);
            }else{
                memory.add(temp);
                times.add(1);
            }
        }

        char result = ' ';
        if(!times.contains(1))
            return result;
        else{
            int position = 0;
            for(;position<times.size();position++){
                if(1==times.get(position))
                    break;
            }
            result = memory.get(position);
        }
        return result;
    }
}
