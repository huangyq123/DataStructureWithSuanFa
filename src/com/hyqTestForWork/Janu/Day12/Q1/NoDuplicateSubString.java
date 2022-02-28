package com.hyqTestForWork.Janu.Day12.Q1;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NoDuplicateSubString
 * @Description TODO 3 无重复字符最长字串   频度 3  medium
 * @Author huangyq
 * @Date 2022/1/12 16:22
 * @Version
 **/
public class NoDuplicateSubString {
    //解法1-滑动窗口——特殊的边界忘记考虑
    //  考虑——在所有子串中进行寻找，对于子串，左边界递增时右边界也在递增（或者不变），这种形式适合滑动窗口
    public int lengthOfLongestSubstring(String s) {

        int left=-1;
        int right=0;
        Set<Character> memory = new HashSet<>();
        int result=0;
        int currentLength=0;
        while(right<s.length()){
            char temp = s.charAt(right);
            if(!memory.contains(temp)){
                currentLength+=1;
                memory.add(temp);
            }else{
                result=Math.max(result,currentLength);
                while(memory.contains(temp)) {
                    left += 1;
                    char deleteTemp = s.charAt(left);
                    memory.remove(deleteTemp);
                    currentLength-=1;
                }
                memory.add(temp);
                currentLength+=1;
            }
            right++;
        }
        //注意特殊的结束情况
        result=Math.max(result,currentLength);

        return result;
    }

    @Test
    public void Test(){
        lengthOfLongestSubstring(" ");
    }
}
