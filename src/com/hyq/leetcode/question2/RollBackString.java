package com.hyq.leetcode.question2;

/**
 * @ClassName RollBackString
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/19 14:50
 * @Version
 **/
public class RollBackString {

    public String longestPalindrome(String s) {
        if (s == null)
            return null;
        if (s.length() <= 1)
            return s;
        if (s.length() == 2 && s.charAt(0) == s.charAt(1))
            return s;

//        int start = 0;
//        int end = 0;
//        int dp = 1;
//
//        int index = 1;
//        while(index<s.length()){
//            if(end<index-1&&dp!=1){
//                continue;
//            }else if(dp==1){
//                start+=1;
//                end+=1;
//                index++;
//            }
//
//            char temp = s.charAt(index);
//            if(start>0&&temp==s.charAt(start-1)){
//                start-=1;
//                end+=1;
//                dp+=2;
//                index++;
//            }else if(start==0){
//
//            }
//        }
//        int[][] dp = new int[s.length()][s.length()];

        return null;
    }
}
