package com.hyq.day13;

/**
 * @ClassName FirstOnceCharInCharStream
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/11 10:12
 * @Version
 **/
public class FirstOnceCharInCharStream {

    static int[] c = new int[128];
    static int index = 0;
    static StringBuffer strB = new StringBuffer();
    public static void add(char ch){
        int temp = ch;
        c[temp]= c[temp] + 1;
        strB.append(ch);
    }


    public static char getFistChar(){
//        if(strB.isEmpty())
//            return ' ';

        char result = ' ';
        if(c[strB.charAt(index)]==1)
            result = strB.charAt(index);
        else if(c[strB.charAt(index)]!=1){
            index++;
            while(index<strB.length()){
                if(c[strB.charAt(index)]==1)
                    result = strB.charAt(index);
                index++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        add('g');
        System.out.println(getFistChar());
        add('o');
        System.out.println(getFistChar());
        add('o');
        System.out.println(getFistChar());
        add('g');
        char r = getFistChar();
        System.out.println(r);
        add('l');
        System.out.println(getFistChar());
        add('e');
        System.out.println(getFistChar());


    }
}
