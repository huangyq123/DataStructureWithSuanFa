package com.hyq.leetcode.SlideWindow.question3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @ClassName Anagrams
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/13 21:08
 * @Version
 **/
public class Anagrams {
    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams2("abacbabc","abc");
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> memory = new LinkedHashMap<>();
        HashMap<Character, Integer> window = new LinkedHashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char temp = p.charAt(i);
            if (memory.containsKey(temp)) {
                memory.put(temp, memory.get(temp) + 1);
            } else {
                memory.put(temp, 1);
            }
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            char temp = s.charAt(right);
            right++;

            if (memory.containsKey(temp)) {
                if (window.containsKey(temp)) {
                    window.put(temp, window.get(temp) + 1);
                } else {
                    window.put(temp, 1);
                }

                if (window.get(temp).equals(memory.get(temp)))  //比较方式
                    valid++;
            }

            while (right - left >= p.length()) {
                if (valid == memory.size()) {
                    result.add(left);
                    char leftChar = s.charAt(left);
                    window.put(leftChar, window.get(leftChar) - 1);
                    valid--;
                    left++;
                } else {
                    char leftChar = s.charAt(left);
                    if (memory.containsKey(leftChar)) {
                        if (window.get(leftChar) == memory.get(leftChar))
                            valid--;
                        window.put(leftChar, window.get(leftChar) - 1);
                    }
                    left++;
                }
            }
        }
        return result;
    }

    //一般的滑动窗
    public static List<Integer> findAnagrams2(String s, String p) {
        if(s==null||p==null||s.length()<p.length())
            return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();

        int length = p.length();
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        int[] memory = new int[26];
        int[] compare = new int[26];

        int count = 0;
        int realCount = 0;

        for (int i = 0; i < pChar.length; i++) {
            if (memory[pChar[i] - 'a'] == 0)
                count += 1;
            memory[pChar[i] - 'a'] += 1;
        }

        int left = 0;
        int right = 0;

        while (right - left < length) {
            if (memory[sChar[right] - 'a'] != 0) {
                compare[sChar[right] - 'a'] += 1;
                if (compare[sChar[right] - 'a'] == memory[sChar[right] - 'a'])
                    realCount += 1;
                else if (compare[sChar[right] - 'a'] == (memory[sChar[right] - 'a'] + 1))
                    realCount -= 1;
            }
            right++;
        }


        if (realCount == count)
            result.add(left);

        while (right < s.length()) {
            if (memory[sChar[right] - 'a'] != 0) {
                compare[sChar[right] - 'a'] += 1;
                if (compare[sChar[right] - 'a'] == memory[sChar[right] - 'a'])
                    realCount += 1;
                else if (compare[sChar[right] - 'a'] == (memory[sChar[right] - 'a'] + 1))
                    realCount -= 1;

            }
            right++;
            if (memory[sChar[left] - 'a'] != 0) {
                if (compare[sChar[left] - 'a'] == memory[sChar[left] - 'a'])
                    realCount -= 1;
                else if (compare[sChar[left] - 'a'] == (memory[sChar[left] - 'a'] + 1))
                    realCount += 1;
                compare[sChar[left] - 'a'] -= 1;

            }
            left++;
            if (realCount == count)
                result.add(left);

        }

        return result;

    }

}
