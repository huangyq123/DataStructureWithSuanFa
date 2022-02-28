package com.hyqTestForWork.Janu.Day18.Q2;

import org.junit.Test;

/**
 * @ClassName MaxLongestSubString
 * @Description TODO  5  最长回文子串 频度 medium
 * @Author huangyq
 * @Date 2022/1/18 20:05
 * @Version
 **/
public class MaxLongestSubString {

    //细节上错太多：
    //  1.注意比较对象和长度判断对象  2.边界条件——没有一次找到，两个索引是-1  3.单中心和双中心都要考虑
    //写法上，可以优化——学习题解  1.19
    public String longestPalindrome(String s){

        if(s==null||s.length()==1){
            return s;
        }
        if(s.length()==2&&s.charAt(0)==s.charAt(1)){
            return s;
        }
        int left = 0;
        int right = 0;
        int maxLength = 1;
        int leftPosition = -1;
        int rightPosition = -1;

            for (int i = 0; i < s.length(); i++) {
                left = i - 1;
                right = i + 1;
                while (left >= 0 && right <= s.length() - 1) {
                    char cLeft = s.charAt(left);
                    char cRight = s.charAt(right);
                    if (cLeft != cRight) {
                        if (maxLength < right - left - 1) {
                            maxLength = right - left - 1;
                            leftPosition = left;
                            rightPosition = right;
                        }
                        break;
                    }
                    left--;
                    right++;
                }
                if (left < 0 || right > s.length() - 1) {
                    if (maxLength < right - left - 1) {
                        maxLength = right - left - 1;
                        leftPosition = left;
                        rightPosition = right;
                    }
                }
            }


            for (int i = 0; i < s.length()-1; i++) {
                if(s.charAt(i)!=s.charAt(i+1)){
                    continue;
                }
                left = i - 1 ;
                right = i + 2;
                while (left >= 0 && right <= s.length() - 1) {
                    char cLeft = s.charAt(left);
                    char cRight = s.charAt(right);
                    if (cLeft != cRight) {
                        if (maxLength < right - left - 1) {//注意是right left
                            maxLength = right - left - 1;
                            leftPosition = left;
                            rightPosition = right;
                        }
                        break;
                    }
                    left--;
                    right++;
                }
                if (left < 0 || right > s.length() - 1) {
                    if (maxLength < right - left - 1) {
                        maxLength = right - left - 1;
                        leftPosition = left;
                        rightPosition = right;
                    }
                }
            }
            if(leftPosition!=rightPosition){  //考虑是否查找到
                return s.substring(leftPosition+1,rightPosition);
            }
            else{
                return s.substring(0,1);
            }
    }

    //解法二  动态规划

    @Test
    public void Test(){
        String cbbd = longestPalindrome("ac");
        System.out.println(cbbd);
    }
}
