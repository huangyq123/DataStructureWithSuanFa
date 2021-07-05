package com.hyq.day14;

/**
 * @ClassName LeftReverseString
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/12 14:12
 * @Version
 **/
public class LeftReverseString {

    //重点——String内存空间分配
    public static String reverseLeftWords(String s, int n){
        if(s==null)
            return null;
        if(s.length()<=n)
            return s;

        StringBuffer temp = new StringBuffer();
        temp.append(s.substring(n,s.length()));
        temp.append(s.substring(0,n));
        return temp.toString();
    }
}
