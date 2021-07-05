package com.hyq.leetcode.SlideWindow.question1;

/**
 * @ClassName subStringMinWindow
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/13 17:58
 * @Version
 **/
public class subStringMinWindow {

    public static void main(String[] args) {
        String test = "ADOBECODEBANC";

        String abc = minWindow("a", "a");
        System.out.println(abc);
    }

    //问题：使用数组记录，目标串存在重复字符则无法处理
    public static String minWindow(String s, String t) {
        if(s==null||t==null||s.length()<t.length())
            return "";

        char[] temp1 = s.toCharArray();
        char[] temp2 = t.toCharArray();

        boolean[] flagArray = new boolean[temp2.length];            //标记是否找到对应字符
        int[] times = new int[temp2.length];                      //记录对应字符在子串中的出现次数


        int pointOfsLeft = 0;                                    //字串的起始位置、结束位置
        int pointOfsRight = 0;


        boolean flag = false;                  //边界切换标志
        StringBuffer result = new StringBuffer();
        while (pointOfsLeft <= pointOfsRight && (pointOfsRight <temp1.length||flag==true)) {   //边界条件
            if (!flag && pointOfsRight < (temp1.length)) {                            //还未找到包含目标子串的子串，继续扩大右边界

                int index = findIndex(temp1[pointOfsRight], t);                       //当前增加的右边界的字符是否有效
                if (index < 0){       //无效
                    pointOfsRight+=1;
                    continue;
                }

                if (!flagArray[index]) {    //该字符在需要找的目标子串中且是第一次找到

                    flagArray[index] = true;
                    flag = true;

                    for (int i = 0; i < flagArray.length; i++)           //是否找到目标子串中所有字符
                        flag = flag && flagArray[i];

                    if (flag) {            //找到所有字符，进行更新结果
                        int length = pointOfsRight - pointOfsLeft + 1;
                        if (result.length()!=0&& result.length() > length) {              //if-else分支
                            result.delete(0, result.length());
                            result.append(s.substring(pointOfsLeft, pointOfsRight + 1));
                        }else if(result.length()==0){
                            result.append(s.substring(pointOfsLeft, pointOfsRight + 1));
                        }

                    }
                }

                times[index] += 1;
                pointOfsRight+=1;                          //边界右移
            }

            else if(flag){                                  //收缩左边界
                int index = findIndex(temp1[pointOfsLeft],t);                //收缩的左边界是否是目标字符
                if(index<0){      //否
                    pointOfsLeft+=1;
                    continue;
                }
                if(times[index]==1){    //是目标字符且正好只有一个，则去掉该字符的子串不是目标子串，要进行更新
                    int length = pointOfsRight - pointOfsLeft ;
                    if (result.length() > length) {
                        result.delete(0, result.length());
                        result.append(s.substring(pointOfsLeft, pointOfsRight));
                    }
                    flagArray[index] = false;
                    flag=false;
                }
                times[index]-=1;                  //边界右移
                pointOfsLeft+=1;
            }
        }

       return  result.length()>0?result.toString():"";
    }

    public static int findIndex(char c, String t) {
        char[] temp = t.toCharArray();
        int index = 0;
        while (index < temp.length) {
            if (c == temp[index])
                break;
            index++;
        }
        return index < temp.length ? index : -1;
    }



}
