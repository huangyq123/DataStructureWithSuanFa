package com.hyq.day10;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @ClassName StringLine
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/8 15:23
 * @Version
 **/
public class StringLine {

    public static void main(String[] args) {
        pailieString("kzfxxx");
        System.out.println(1);
    }

    static StringBuffer result = new StringBuffer();  //选用的数据结构

    public static String[] pailieString(String s) {
        char[] c = s.toCharArray();
        Assist(0, c);
        String value = result.toString();
        return value.substring(0, value.length()).split(",");
    }

    public static void Assist(int position, char[] c) {
        if (position == c.length - 1) {
            result.append(c);
            result.append(",");
            return;
        }
        HashSet<Character> set = new HashSet<>();     //剪枝实现？
        for (int x = position; x < c.length; x++) {
            if (set.contains(c[x])) continue;
            swap(c, position, x);
            Assist(position + 1, c);
            swap(c, position, x);
            set.add(c[x]);
        }
    }

    public static void swap(char[] c, int position, int x) {
        char temp = c[position];
        c[position] = c[x];
        c[x] = temp;
    }


}
