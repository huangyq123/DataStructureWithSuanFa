package com.hyqTestForWork.March.Day9.Q3;

import java.util.Stack;

/**
 *@Author admin
 *@Description TODO  32. 最长有效括号  hard
 *@Date 2022/3/9 17:14
 *@Param
 *@return
 *@Version
 **/
public class LongestValidSprase {
    //只完成了一部分功能，有问题：完成了左半部分
    public int longestValidParentheses(String s){

        Stack<Character> memory = new Stack<>();

        int index = 0;
        int length = 0;
        int result = 0;
        while(index<s.length()){
            char temp = s.charAt(index);
            if(temp=='('){
                memory.push(temp);
                index++;
            }else{
                if(!memory.isEmpty()&&memory.peek()=='('){
                    memory.pop();
                    length+=1;
                }else{
                    result = Math.max(length,result);
                    memory.push(temp);
                    length=0;
                }
                index++;
            }
        }

        result = Math.max(length,result);
        int result1 = 0;
        length=0;
        index=s.length()-1;
        while(index>=0){
            char temp = s.charAt(index);
            if(temp==')'){
                memory.push(temp);
                index--;
            }else{
                if(!memory.isEmpty()&&memory.peek()==')'){
                    memory.pop();
                    length+=1;
                }else{
                    result1 = Math.max(length,result1);
                    memory.push(temp);
                    length=0;
                }
                index--;
            }
        }

        result1 = Math.max(length,result1);

        result = Math.max(result,result1);

        return result*2;
    }

    //TODO  栈实现
    public int longestValidParentheses2(String s){
        return -1;
    }

    //TODO  双遍历
}
