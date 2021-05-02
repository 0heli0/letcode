package com.heli.letcode.basics.str;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: heLi
 * @Date: 2021/5/2
 */
public class Day2 {
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {

            if (!set.add(chars[i])) {
                map.put(chars[i], i);
            }


        }

        for (int i = 0; i < chars.length; i++) {

            if (!map.containsKey(chars[i])) {
                return i;
            }


        }
        return -1;

    }

    public static boolean isAnagram(String s, String t) {

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    public static boolean isPalindrome(String s) {
        // 去除字母外其他字符
        StringBuilder sgood = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }

        String actual = sgood.toString().toLowerCase();
        int begin = 0;
        int end = actual.length() - 1;
        while (begin < end) {
            if (actual.charAt(begin) != actual.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public int myAtoi(String str) {
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

    public static int strStr(String haystack, String needle) {

        if ("".equals(needle)) {
            return 0;
        }
        String[] split = haystack.split(needle);
        if (split.length == 0) {
            return 0;
        }
        if ((split.length > 1 || haystack.length() > split[0].length())) {
            return split[0].length();
        }
        return -1;
    }

    public static String countAndSay(int n) {

        String str = "1";
        for (int i = 0; i < n - 1; i++) {
            int start = 0;
            int end = 0;
            int num = 1;
            StringBuilder string = new StringBuilder();
            char[] chars = str.toCharArray();
            if(str.length() == 1){
                str = "1"+str;
                continue;
            }
            while (end < chars.length-1){
                if(chars[start] == chars[++end]){
                    num++;
                }else {
                    string.append("").append(num).append(chars[start]);
                    num = 1;
                }
                if(end == chars.length-1){
                    string.append("").append(num).append(chars[end]);
                }
                start++;
            }
            str = string.toString();
        }

        return str;
    }

    public static void main(String[] args) {

        String result = countAndSay(6);

        System.out.println(result);





    }
}
