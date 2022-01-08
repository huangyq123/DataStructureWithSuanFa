package com.hyqTestForWork.Janu.Day5.Q4;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName MaxSubArraySum
 * @Description TODO  20 有效括号  hot100  easy
 * @Author huangyq
 * @Date 2022/1/4 20:21
 * @Version
 **/
public class ValidParse {
    public boolean isValid(String s) {
        Stack<String> memory = new Stack<>();

        boolean result=true;

        for(int i=0;i<s.length();i++){
            String substring = s.substring(i, i + 1);
            if(")".equals(substring)){
                if(memory.isEmpty()||!"(".equals(memory.peek())){
                    result = false;
                    break;
                }
                memory.pop();
            }else if("]".equals(substring)){
                if(memory.isEmpty()||!"[".equals(memory.peek())){
                    result = false;
                    break;
                }
                memory.pop();
            }else if("}".equals(substring)){
                if(memory.isEmpty()||!"{".equals(memory.peek())){
                    result = false;
                    break;
                }
                memory.pop();
            }else{
                memory.push(substring);
            }
        }

        if(!memory.isEmpty()){
            result=false;
        }

        return result;
    }

    @Test
    public void Test(){
        isValid("()");
    }
}
