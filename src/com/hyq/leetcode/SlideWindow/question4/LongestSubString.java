package com.hyq.leetcode.SlideWindow.question4;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @ClassName LongestSubString
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/14 19:37
 * @Version
 **/
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
            return 0;
        int result = 0;

        HashMap<Character,Integer> temp = new LinkedHashMap<>();

        int left = 0;
        int right = 0;
        boolean flag = false;

        while(right<s.length()){
            char c = s.charAt(right);
            right++;

            if(!temp.containsKey(c)||temp.get(c)==0){//判断条件要分清楚有什么情况
                temp.put(c,1);
            }else{
                temp.put(c,temp.get(c)+1);
                flag = true;
            }

            while(flag){
                if(result<(right-left-1)){
                    result = right-left-1;
                }
                char t = s.charAt(left);
                left++;

                temp.put(t,temp.get(t)-1);
                if(t==c)
                    flag = false;

            }
        }

        result = Math.max(result, (right - left));//注意边界条件
        return result;
    }

    public static void main(String[] args) {
        int s = lengthOfLongestSubstring("tmmzuxt");
        System.out.println(s);
    }
}
