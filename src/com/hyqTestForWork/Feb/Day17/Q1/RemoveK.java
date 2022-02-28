package com.hyqTestForWork.Feb.Day17.Q1;

import java.util.Stack;

/**
 * @ClassName RemoveK
 * @Description TODO  402. 移掉 K 位数字  频度 medium
 * @Author huangyq
 * @Date 2022/2/17 18:34
 * @Version
 **/
public class RemoveK {
    //思路正确，但是实现细节没想清楚，导致改了好几次
    //  一定搞清楚细节
    public String removeKdigits(String num, int k) {

        if(num.length()==k){
            return "0";
        }

        Stack<Integer> memory = new Stack<>();
        int index=0;
        //保证栈是非减的，这样就能得到最小值
        while(index<num.length()&&k>0){
            int temp = num.charAt(index)-'0';
            if(memory.isEmpty()){
                memory.push(temp);
                index++;
            }else{
                if(memory.peek()>temp){
                    //出现新元素比栈顶元素小时，栈顶元素出栈；  注意，新的栈顶依然可能比当前值大，因此需要再比较，index先不修改
                    memory.pop();
                    k--;
                }else {
                    memory.push(temp);
                    index++;
                }
            }
        }
        //可能没删够
        while(k>0){
            memory.pop();
            k--;
        }

        StringBuilder strB = new StringBuilder("");
        if(index<num.length()){
            //可能有剩余
            for(int m=num.length()-1;m>=index;m--){
                strB.append(num.charAt(m));
            }
        }

        //拼接字符串
        while(!memory.isEmpty()){
            Integer pop = memory.pop();
            strB.append(pop);
        }

        if(strB.length()>0){
            //考虑前导0
            String s = strB.reverse().toString();
            int i=0;
            for(;i<s.length();i++){
                String substring = strB.substring(i, i + 1);
                if(!"0".equals(substring)){
                   break;
                };
            }
            return i==s.length()?"0":s.substring(i,s.length());
        }else{
            return "0";
        }

    }


    //TODO  使用双向队列实现栈，方便前导0的处理


}
