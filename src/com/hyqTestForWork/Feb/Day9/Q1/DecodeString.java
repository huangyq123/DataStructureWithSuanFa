package com.hyqTestForWork.Feb.Day9.Q1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName DecodeString
 * @Description TODO 394. 字符串解码  频度 medium
 * @Author huangyq
 * @Date 2022/2/9 15:30
 * @Version
 **/
public class DecodeString {
    //栈实现
    //细节上注意不要用错量
    public String decodeString(String s){

        StringBuilder strB = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        int index=0;
        while(index<s.length()){
            char c = s.charAt(index);
            if(c!=']'){
                stack.push(c);
            }else{
                StringBuilder tempStrB = new StringBuilder();
                while(!stack.peek().equals('[')){
                    tempStrB.append(stack.pop());
                }

                stack.pop();
                int multiply = 0;
                int times = 1;
                while(!stack.isEmpty()&&(stack.peek()>='0'&&stack.peek()<='9')){
                     multiply = multiply + (stack.pop() - '0')*times;
                     times*=10;
                }

                for(int i=0;i<multiply;i++){
                    for(int k= tempStrB.length()-1;k>=0;k--){
                        stack.push(tempStrB.charAt(k));
                    }
                }

            }
            index++;
        }

        while(!stack.isEmpty()){
            strB.append(stack.pop());
        }

        String result = strB.reverse().toString();
        return result;
    }


    //TODO  递归实现
    //每次遇到[]就需要进行一次重新的递归统计得到内部结果
    public String decodeString2(String s){
        List<String> decode = decode(s, 0);

        return decode.get(0);
    }

    public List<String> decode(String s, int index){

        StringBuilder strB = new StringBuilder();
        int times = 0;
        for(;index<s.length();index++){
            char c = s.charAt(index);
            if(c>='0'&&c<='9'){
                times = times*10 + (c-'0');
            }else if(c=='['){
                List<String> decode = decode(s, index + 1);
                String tempString = decode.get(0);
                for(int k=0;k<times;k++){
                    strB.append(tempString);
                }
                times = 0;
                index = Integer.parseInt(decode.get(1));
            }else if(c==']'){
                break;
            }else{
                strB.append(c);
            }

        }
        List<String> result = new ArrayList<>();
        result.add(strB.toString());
        result.add(Integer.toString(index));
        return result;
    }

    @Test
    public void Test(){
        String test = "100[leetcode]";
        String s = decodeString2(test);
        System.out.println(s.length());
    }
}
