package com.hyq.leetcode2.june.twelve;

/**
 * @ClassName LongestCircleString
 * @Description TODO  最长回文子串  NO.5
 * @Author huangyq
 * @Date 2021/6/12 18:50
 * @Version
 **/
public class LongestCircleString {

    public static String longestPalindrome(String s) {
        if(s==null||s.length()<=1){
            return s;
        }

//        //思路：动态规划，每一个位置记录以当前位置结尾的最长回文串，下一个位置在此基础上查找最长串；问题：偶数的处理不易实现，  查找索引向前越界？
//        int start=0;
//        int end = 0;
//        int length=1;
//
//        int index=1;
//        while(index<s.length()){
//            if(index==1){
//                if(s.charAt(1)==s.charAt(0)){
//                    length=2;
//                    start=0;
//                    end=1;
//                }else{
//                    start=1;
//                    end=1;
//                    length=1;
//                }
//                index++;
//            }
//            else{
//
//            }
//        }


        //中心扩散
        int start=0;
        int end=0;
        int length=1;

        for(int i =1;i<s.length();i++){
            int left=i-1;
            int right=i+1;

            //奇数长度处理
            while(left>=0&&right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                }else{

                    break;
                }
            }

            if(right-left-1>length){
                start=left+1;
                end=right-1;
                length=right-left-1;
            }

            //偶数长度处理
            left=i-1;
            right=i;
            while(left>=0&&right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                }else{
                    break;
                }
            }


            if(right-left-1>length){
                start=left+1;
                end=right-1;
                length=right-left-1;
            }
        }

        return s.substring(start,end+1);
    }

    public static void main(String[] args) {
        String test="cbbd";
        String s = longestPalindrome(test);
        System.out.println(s);
    }
}
