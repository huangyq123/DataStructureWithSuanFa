package com.hyq.leetcode2.july.thirteen.Q2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Introduce
 * @Description TODO  22. 括号生成
 * @Author huangyq
 * @Date 2021/7/13 18:49
 * @Version
 **/
public class Introduce {

    public static List<String> generateParenthesis(int n) {

        List<String> s= new ArrayList<>();
        StringBuffer temp = new StringBuffer();
        deep(s,temp,n,n);

        return s;
    }

    public static void deep(List<String> s, StringBuffer temp,int nLeft,int nRight){
        if(nLeft==0&&nRight==0){
            StringBuffer result= new StringBuffer();
            for(int i=0;i<temp.length();i++){
                result.append(temp.charAt(i));
            }
            s.add(result.toString());
            return ;
        }

        if(nLeft>0){
            temp.append("(");
            deep(s,temp,nLeft-1,nRight);
            temp.delete(temp.length()-1,temp.length());
        }

        if(nRight-1>=nLeft){
            temp.append(")");
            deep(s,temp,nLeft,nRight-1);
            temp.delete(temp.length()-1,temp.length());
        }
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(4);
        for(String x:strings){
            System.out.println(x);
        }
        System.out.println(strings.size());
    }
}
