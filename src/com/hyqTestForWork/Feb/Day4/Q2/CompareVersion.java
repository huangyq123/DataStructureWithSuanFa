package com.hyqTestForWork.Feb.Day4.Q2;

import org.junit.Test;

/**
 * @ClassName CompareVersion
 * @Description TODO  165. 比较版本号  频度 medium
 * @Author huangyq
 * @Date 2022/2/4 10:37
 * @Version
 **/
public class CompareVersion {
    //使用内置split分割
    //分割完后不同长度情况下的比较可以优化
    //split函数的参数格式——？？
    // https://blog.csdn.net/myfmyfmyfmyf/article/details/37592711?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-1.pc_relevant_default&spm=1001.2101.3001.4242.2&utm_relevant_index=4
    public int compareVersion(String version1, String version2) {

        //这里时使用正则表达式分割，特殊符号需要使用特殊处理；
        String[] version1Array = version1.split("[.]");
        String[] version2Array = version2.split("[.]");
        int maxlength = Math.max(version1Array.length,version2Array.length);
        int minlength = Math.min(version1Array.length,version2Array.length);
        for(int i=0;i<maxlength;i++){
            if(i<minlength){
                int valueV1 = Integer.parseInt(version1Array[i]);
                int valueV2 = Integer.parseInt(version2Array[i]);
                if(valueV1>valueV2){
                    return 1;
                }else if(valueV1<valueV2){
                    return -1;
                }else{
                    continue;
                }
            }else{
                if(version1Array.length==i){
                    int k = i;
                    while(k<maxlength){
                        int v2 = Integer.parseInt(version2Array[k]);
                        if(v2>0){
                            return -1;
                        }
                    }
                }else if(version2Array.length==i){
                    int k = i;
                    while(k<maxlength){
                        int v1 = Integer.parseInt(version1Array[k]);
                        if(v1>0){
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }

    //TODO 手动分割实现——双指针
    public int compareVersion2(String version1, String version2){

        int i=0;
        int j=0;

        while(i<version1.length()||j<version2.length()){
            int compare1 = 0;
            int m = i;
            for(;m<version1.length();m++){
                if(version1.charAt(m)=='.'){
                    break;
                }
            }
            if(i<version1.length()){
                compare1 = Integer.parseInt(version1.substring(i,m));
                i = m+1;
            }

            int compare2 = 0;
            int n = j;
            for(;n<version2.length();n++){
                if(version2.charAt(n)=='.'){
                    break;
                }
            }
            if(j<version2.length()){
                compare2 = Integer.parseInt(version2.substring(j,n));
                j = n+1;
            }

            if(compare1<compare2){
                return -1;
            }else if(compare1>compare2){
                return 1;
            }

        }

        return 0;
    }

    @Test
    public void Test(){

//        String s = "001";
//        int i = Integer.parseInt(s);
//        System.out.println(i);

        compareVersion("0.1","1.1.0");
    }

}
