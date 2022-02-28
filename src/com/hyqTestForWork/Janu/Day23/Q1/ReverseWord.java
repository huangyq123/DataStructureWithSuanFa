package com.hyqTestForWork.Janu.Day23.Q1;

/**
 * @ClassName ReverseWord
 * @Description TODO  151  反转字符串里的单词 频度 medium
 * @Author huangyq
 * @Date 2022/1/23 19:19
 * @Version
 **/
public class ReverseWord {
    //实现本身不难，但是一直纠结于空间复杂度——  java实现不了O(1),这里使用字符串存储也是O(n)
    public String reverseWords(String s) {

        if(s==null){
            return null;
        }

        String result = "";
        int left = s.length()-1;
        int right = s.length();
        while(left>=0){
            if(s.charAt(left)!=' '){
                left--;
            }else{
                if(left+1<right) {
                    result = result + s.substring(left + 1, right);
                }
                right=left+1;
                while(left>=0&&s.charAt(left)==' '){
                    left--;
                }
                if(left>=0) {
                    result = result + " ";
                    right = left + 1;
                }
            }
        }

        if(s.charAt(0)!=' '){
            result = result + s.substring(left+1,right);
        }
        left = 0;
        right = result.length();
        if(result.charAt(0)==' '){
            left = 1;
        }
        if(result.charAt(result.length()-1)==' '){
            right = result.length()-1;
        }

//        if(result.charAt(result.length()-1)==' '){
//            return result.substring(r)
//        }

        return result.substring(left,right);
    }

    //TODO  双端队列处理 1.24
}
