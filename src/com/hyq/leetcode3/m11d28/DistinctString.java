package com.hyq.leetcode3.m11d28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName DistinctString
 * @Description TODO
 * @Author huangyq
 * @Date 2021/11/28 20:56
 * @Version
 **/
public class DistinctString {
    public static List<Integer> findAnagrams(String s, String p) {

        if(s==null||p==null||s.length()<p.length()){
            return new ArrayList<Integer>();
        }

        int[] memory = new int[26];
        for(int i=0;i<p.length();i++){
            int temp = p.charAt(i)-'a';
            memory[temp]+=1;
        }

        int[] tempMemory = new int[26];
        int left = 0;
        int right = p.length()-1;
        int current = 0;
        List<Integer> result = new ArrayList<>();
        while(right<s.length()){

            if(current>right){
                result.add(left);
                tempMemory[s.charAt(left)-'a']-=1;
                left+=1;
                right+=1;
                continue ;
            }

            int temp = s.charAt(current)-'a';
            if(memory[temp]==0){
                left = current+1;
                right = left+p.length()-1;
                current = left;

                //初始化tempMemory
                Arrays.fill(tempMemory,0);
            }else if(memory[temp]<=tempMemory[temp]){
                //
                while(left<current){
                    int c = s.charAt(left)-'a';
                    left+=1;
                    right+=1;
                    tempMemory[c]-=1;
                    if(c==temp){
                        break;
                    }
                }

                tempMemory[temp]+=1;
                current+=1;

            }else {
                tempMemory[temp]+=1;
                current+=1;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("abab", "ab");
        for(int i:anagrams){
            System.out.println(i+" ");
        }
    }
}
