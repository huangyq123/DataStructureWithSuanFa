package com.hyqTestForWork.March.Day9.Q2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 *@Author admin
 *@Description TODO  76. 最小覆盖子串 hard
 *@Date 2022/3/9 16:28
 *@Param
 *@return
 *@Version
 **/
public class MinString {
    //经典滑动窗口——重点：更新结果的时间；  循环结束的条件（边界处理）；
    public String minWindow(String s, String t){
        if(s.length()<t.length()){
            return "";
        }
        //记录需要统计的字符的数量
        Map<Character,Integer> memory = new HashMap<>();
        int sum = 0;
        for(int i=0;i<t.length();i++){
            char temp = t.charAt(i);
            if(memory.containsKey(temp)){
                memory.put(temp,memory.get(temp)+1);
            }else{
                memory.put(temp,1);
            }
            sum+=1;
        }

        //结果记录
        int start = -1;
        int end = -1;
        int length = s.length()+1;
        //查找位置记录——双指针
        int slow = 0;
        int fast = 0;
        //考虑到最后一次的结果记录，需要使用sum==0作为条件，否则需要在外部在写一次代码
        while(fast<s.length()||sum==0){
            //没有完成覆盖，扩展右指针
            if(sum>0){
                char temp = s.charAt(fast);
                //更新字符数量和覆盖情况
                if(memory.containsKey(temp)){
                    if(memory.get(temp)>0){
                        sum-=1;
                    }
                    memory.put(temp,memory.get(temp)-1);
                }
                fast++;
            }else if(sum==0){
                //覆盖完成；
                if(fast-slow<length){
                    start = slow;
                    end = fast;
                    length = fast-slow;
                }
                //更新字符数和结果
                char temp = s.charAt(slow);
                if(memory.containsKey(temp)){
                    if(memory.get(temp)>=0){
                        sum+=1;
                    }
                    memory.put(temp,memory.get(temp)+1);
                }
                slow++;
            }
        }
        //考虑边界
        if(start<0||end>s.length()){
            return "";
        }


        return s.substring(start,end);
    }

    @Test
    public void Test(){
        minWindow("ADOBECODEBANC","ABC");
    }

}
