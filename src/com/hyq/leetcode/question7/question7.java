package com.hyq.leetcode.question7;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName question7
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/21 20:00
 * @Version
 **/
public class question7 {

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        char[] temp = new char[n*2];
        Recur(result,temp,0,n,n);
        return result;
    }

    public static void Recur(List<String> result,char[] temp,int position, int left, int right){
        if(left==0&&right==0){
            result.add(new String(temp));
            return ;
        }

        if(left>0){
            temp[position] = '(';
            position+=1;
            Recur(result,temp,position,left-1,right);
            position-=1;
        }

        if(right>left){
            temp[position] = ')';
            position+=1;
            Recur(result,temp,position,left,right-1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
        System.out.println(1);
    }
}
