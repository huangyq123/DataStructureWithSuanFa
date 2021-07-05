package com.hyq.leetcode.backTracing.question17;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IPAdressReturn
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/23 20:23
 * @Version
 **/
public class IPAdressReturn {

    public static List<String> restoreIpAddresses(String s) {
        if(s==null)
            return null;

        if(s.length()<4||s.length()>12)
            return new ArrayList<String>();

        List<String> result = new ArrayList<>();
        StringBuffer temp = new StringBuffer();
        BackTracing(result,temp,0,s,1);
        return result;

    }

    public static void BackTracing(List<String> result,StringBuffer temp,int start,String s,int length){
        if(length == 5&&start==s.length()){
            temp.deleteCharAt(temp.length()-1);
            result.add(temp.toString());
            temp.append(".");   //考虑到回溯的消除问题
            return ;
        }
        else if(start>=s.length()||length>=5)
            return ;

        for(int i = start;i<(start+3)&&i<s.length();i++){
            if(isValid(s,start,i,length)){
                int digit = Integer.parseInt(s.substring(start,i+1));    //前导0
                String str = Integer.toString(digit);
                temp.append(str+".");
                length+=1;
                BackTracing(result,temp,i+1,s,length);
                length-=1;
                for(int k = str.length();k>=0;k--){//变量
                    temp.deleteCharAt(temp.length()-1);
                }
            }
        }

    }

    public static boolean isValid(String s,int start,int end,int length){
        int right = Math.min(s.length()-1,end);
        String t = s.substring(start,right+1);
        int number = Integer.parseInt(t);
        if(number>255)
            return false;
        else if(number!=0&&t.charAt(0)=='0')    //前导0
            return false;
        else if(number==0&&t.length()>1)
            return false;
        else
            return true;

    }

    public static void main(String[] args) {
        String test = new String("010010");
        List<String> result = restoreIpAddresses(test);
        System.out.println(1);
    }

}
