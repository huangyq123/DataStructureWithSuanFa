package com.hyq.leetcode2.Augest.Eleven.Q2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TelNumber
 * @Description TODO  17. 电话号码的字母组合
 * @Author huangyq
 * @Date 2021/8/11 15:59
 * @Version
 **/
public class TelNumber {
    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return null;
        }

        int length = 0;
        String[] memory = new String[]{" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] temp = new char[digits.length()];
        List<String> result = new ArrayList<>();
        deep(result,memory,length,digits,temp,0);

        return result;
    }

    public static void deep(List<String> result,String[] memory,int length,String digits,char[] temp,int charIndex){
        if(length==digits.length()){
            StringBuffer strB = new StringBuffer();
            strB.append(temp);
            result.add(strB.toString());
            return ;
        }

        int index = (int) digits.charAt(length)-48;
        String s= memory[index];
        for(int m=0;m<s.length();m++){
            temp[charIndex]=s.charAt(m);
            deep(result,memory,length+1,digits,temp,charIndex+1);

        }
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("345");
        for(String s:strings){
            System.out.println(s);
        }
    }
}
