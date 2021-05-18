package com.heli.letcode.basics;

import java.util.*;

/**
 * @Author: heLi
 * @Date: 2021/5/15
 */
public class Daily {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        List<Character> roman = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M');
        List<Integer> list = Arrays.asList(1, 5, 10, 50, 100, 500, 1000);
        for (int i = 0; i < roman.size(); i++) {
            map.put(roman.get(i), list.get(i));
        }
        char[] chars = s.toCharArray();
        int result = 0;
        int i = 1;
        int pre = map.get(chars[0]);
        while (i < chars.length) {
            int num = map.get(chars[i]);
            if (pre < num) {
                result -= pre;
            } else {
                result += pre;
            }
            pre = num;
            i++;
        }

        result += pre;

        return result;
    }

    /**
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxNum = 0;
        if (s == null || s.length() == 0) return maxNum;
        if (s.length() == 1) return 1;
        char[] bytes = s.toCharArray();
        int index = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < bytes.length; i++) {
            if(map.containsKey(bytes[i])){
                index = Math.max(index, map.get(bytes[i]) +1);
            }
            map.put(bytes[i],i);
            maxNum = Math.max(maxNum, i - index +1);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        Daily daily = new Daily();
        int result = daily.lengthOfLongestSubstring("abcabcdabca");
        System.out.println(result);
    }

}
