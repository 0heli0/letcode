package com.heli.letcode.basics.str;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: YourName
 * @Date: 2021/5/6
 */
public class Day3 {
    public static String longestCommonPrefix(String[] strs) {

        if(strs.length==0)  return "";
        int len=strs.length;    //用于存储字符串遍历的最小长度
        //外层for循环遍历每个字符索引，注意strs[0].length长度是不断变化的
        for(int i=0;i<strs[0].length();i++){
            //取出单个字符，用于字符串之间的匹配
            char c=strs[0].charAt(i);
            //内层for循环遍历每个字符串
            for(int j=0;j<len;j++){
                /*当需要匹配的字符索引超过字符串的长度，
                    或者字符串某个位置的字符不匹配时，削减最长前缀
                    同时要刷新字符串遍历的最小长度len（因为超过len的部分肯定不匹配了）*/
                if(i==strs[j].length() || strs[j].charAt(i)!=c){
                    strs[0]=strs[0].substring(0,i);
                    len=j;
                }
            }
        }
        //返回最长公共前缀
        return strs[0];
    }


    public static void main(String[] args) {
        String result = longestCommonPrefix(new String[]{"abcde", "ab", "abcc"});
        System.out.println(result);

    }
}
