package com.hyq.leetcode.question1;

import java.util.Stack;

/**
 * @ClassName ValidChar
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/18 22:26
 * @Version
 **/
public class ValidChar {

    public static boolean isValid(String s) {
        if (s == null)
            return false;

        Stack<Character> memory = new Stack<>();
        int length = s.length();
        int i = 0;

        while (i < length) {
            char temp = s.charAt(i);
            int flag = 0;
            if (temp == ')')
                flag = 1;
            else if (temp == '}')
                flag = 2;
            else if (temp == ']')
                flag = 3;

            if (flag == 0||memory.isEmpty())
                memory.push(temp);
            else {
                boolean result = false;

                if (flag == 1 && memory.peek() == '(') {
                    memory.pop();
                    result = true;

                } else if (flag == 2 && memory.peek() == '{') {
                    memory.pop();
                    result = true;

                } else if (flag == 3 && memory.peek() == '[') {
                    memory.pop();
                    result = true;

                }

                if (!result)
                    memory.push(temp);
            }
            i++;
        }
        return memory.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("{[]}");
        System.out.println(valid);
    }
}
