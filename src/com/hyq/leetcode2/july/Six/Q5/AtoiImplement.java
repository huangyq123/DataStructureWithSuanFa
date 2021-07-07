package com.hyq.leetcode2.july.Six.Q5;

/**
 * @ClassName AtoiImplement
 * @Description TODO
 * @Author huangyq
 * @Date 2021/7/6 21:07
 * @Version
 **/
public class AtoiImplement {
    public static int myAtoi(String s) {
        //边界处理——空串处理
        if(s==null){
            return 0;
        }
        s=s.trim();
        //边界处理——没有字符时处理
        if(s.length()==0){
            return 0;
        }

        //符号记录
        int signal =0;
        if(s.charAt(0)=='-'){
            signal=-1;
        }else if(s.charAt(0)=='+'){
            signal=1;
        }else if(s.charAt(0)>='0'&&s.charAt(0)<='9'){
            signal=3;
        }else{
            return 0;
        }

        //记录可用数字字符串的末尾位置，index指向第一个不可用位置
        int index=1;
        while(index<s.length()){
            if(s.charAt(index)>='0'&&s.charAt(index)<='9'){
                index++;
                continue;
            }else{
                break;
            }
        }

        int result=0;

        //符号开头的情况获取结果
        if((signal==1||signal==-1)&&index>1){
            //记录第一个非零值位置
            int start=1;
            for(;start<index-1;start++){
                if(s.charAt(start)!='0') {
                    break;
                }
            }
            //边界处理
            if(index-start<10){
                result=Integer.parseInt(s.substring(start,index));
                result=result*signal;
            }else if(index-start>10){
                result=signal==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }else {
                long temp=Long.parseLong(s.substring(start,index))*signal;
                if(temp<(long) Integer.MIN_VALUE){
                    result=Integer.MIN_VALUE;
                }else if(temp >(long) Integer.MAX_VALUE){
                    result=Integer.MAX_VALUE;
                }else {
                    result= (int) temp;
                }
            }
        }
        //数字开头的情况获取结果
        else if(signal==3){
            //记录第一个非零值位置
            int start2=0;
            for(;start2<index-1;start2++){
                if(s.charAt(start2)!='0') {
                    break;
                }
            }
            if(index-start2<10){
                result=Integer.parseInt(s.substring(start2,index));
            }else if(index-start2>10){
                result=Integer.MAX_VALUE;
            }else{
                long temp=Long.parseLong(s.substring(start2,index));
                if(temp >(long) Integer.MAX_VALUE){
                    result=Integer.MAX_VALUE;
                }else {
                    result= (int) temp;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int i = myAtoi("-2147483646");
        System.out.println(i);
    }
}
