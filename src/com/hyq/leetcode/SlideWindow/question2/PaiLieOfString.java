package com.hyq.leetcode.SlideWindow.question2;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @ClassName PaiLieOfString
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/13 20:02
 * @Version
 **/
public class PaiLieOfString {
    public static void main(String[] args) {

        boolean b = checkInclusion("abc", "dbaac");
        System.out.println(b);
    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> memory = new LinkedHashMap<>();
        HashMap<Character, Integer> window = new LinkedHashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!memory.containsKey(c))
                memory.put(c, 1);
            else
                memory.put(c, memory.get(c) + 1);
        }


        int left = 0;
        int right = 0;
        int valid = 0;
        boolean flag=false;

        while (right < s2.length()) {
            char temp = s2.charAt(right);
            right++;

            if (memory.containsKey(temp)) {
                if (window.containsKey(temp))
                    window.put(temp, window.get(temp) + 1);
                else
                    window.put(temp, 1);

                if(memory.get(temp).equals(window.get(temp)))
                    valid++;
                else if(memory.get(temp)<window.get(temp)){           //当某个值的数量过多则说明不正确
                    while(memory.get(temp)<window.get(temp)){
                        char shrink = s2.charAt(left);
                        if(window.containsKey(shrink)){
                            if(window.get(shrink).equals(memory.get(shrink)))
                                valid--;
                            window.put(shrink,window.get(shrink)-1);
                        }
                        left++;
                    }
                }
            }else{      //出现不属于的字符
                window.clear();
                valid=0;
                left=right;   //重新指定边界
            }

            if(valid==memory.size()){
                flag=true;
                break;
            }
        }
        return flag;
    }
}
