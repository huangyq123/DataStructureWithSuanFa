package com.hyqTestForWork.Feb.Day10.Q1;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName Calculator
 * @Description TODO  227. 基本计算器 II  频度 medium
 * @Author huangyq
 * @Date 2022/2/10 20:08
 * @Version
 **/
public class Calculator {
    //实现细节太乱——bug 结尾数字没有处理（给s加一个空格来处理）；  从栈查看栈顶元素没有想清楚什么时候判断栈空；  重新初始化记录值temp
    public int calculate(String s) {

        Stack<Character> symbol = new Stack<>();
        Stack<Integer> number = new Stack<>();
        //避免最后一个数字没有进行计算；
        s = s+" ";

        int index = 0;
        int temp = 0;
        boolean flag = false;
        while(index<s.length()){
            char c = s.charAt(index);
            if(c==' '||c=='+'||c=='-'||c=='*'||c=='/'){
                if(flag==true){
                    char tempSymbol ='0' ;
                    if(!symbol.isEmpty()) {
                        tempSymbol = symbol.peek();
                    }
                    while(tempSymbol=='*'||tempSymbol=='/') {
                        symbol.pop();
                        if (tempSymbol == '*') {
                            int tempValue = number.pop();
                            temp = temp * tempValue;
                        } else if (tempSymbol == '/') {
                            int tempValue = number.pop();
                            temp = tempValue / temp;
                        }
                        if(!symbol.isEmpty()) {
                            tempSymbol = symbol.peek();
                        }else {
                            break;
                        }
                    } //优化——不需要循环考虑，因为已经每次出现都进行了处理
                    number.push(temp);
                    flag=false;
                    temp=0;
                }
                if(c!=' ') {
                    symbol.push(c);
                }
            }else{
                flag = true;
                temp = temp*10 + (c-'0');
            }
            index++;
        }

        int result = 0;
        while(!number.isEmpty()){
            int tempResult = number.pop();
            if(symbol.isEmpty()){
                result += tempResult;
            }else{
                char c = symbol.pop();
                if(c=='+'){
                    result+=tempResult;
                }else{
                    result-=tempResult;
                }
            }
        }

        return result;
    }

    //TODO  优化处理

    //TODO  单个栈实现

    @Test
    public void Test(){
        String test = "3+2*2";
        calculate(test);
    }
}
