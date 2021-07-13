package com.hyq.leetcode2.july.thirteen.Q1;

import java.util.Stack;

/**
 * @ClassName StringDecoding
 * @Description TODO  394. 字符串解码
 * @Author huangyq
 * @Date 2021/7/13 18:14
 * @Version
 **/
public class StringDecoding {
    //使用栈来处理——对于整个字符串来说，应该先将最内层的方括号进行计算，再一层一层往外扩展。 从[的角度来看，最后的[最先处理：后进先出思想——利用栈存储则能实现
    public static String decodeString(String s) {
        Stack<Character> memory=new Stack<>();

        int index=0;
        StringBuffer temp = new StringBuffer();
        //开始遍历
        while(index<s.length()){
            char c = s.charAt(index);
            //未读到]，进行入栈
            if(c !=']'){
                memory.push(c);
                index++;
                continue;
            }else{
                //读到]，则开始获取当前最内层的[]包含的内容
                char current=memory.pop();
                while (current!='['){
                    temp.append(current);
                    current=memory.pop();
                }

                //获取完[]的内容后，开始获取数字来计算重复次数
                int times=0;
                int multi=1;
                current=memory.pop();
                //考虑不止为0-9的情况
                while((current-'0')>=0&&(current-'0')<=9){
                    times+=(((int)(current-'0'))*multi);
                    multi*=10;
                   if(!memory.isEmpty()) {
                       current=memory.pop();
                   } else {
                       break;
                   }
                }
                if(!memory.isEmpty()) {
                    memory.push(current);
                }

                //进行解码，并重新入栈，得到解码后的字符串
                for(int k=0;k<times;k++){
                    for(int m=temp.length()-1;m>=0;m--){
                        memory.push(temp.charAt(m));
                    }
                }
                temp.delete(0,temp.length());
                index++;
            }
        }

        //获取结果，这里的结果是倒序的
        while(!memory.isEmpty()){
            temp.append(memory.pop());
        }

        return temp.reverse().toString();
    }

    public static void main(String[] args) {
        String s = decodeString("10[abc]3[cd]ef");
        System.out.println(s);
    }
}
