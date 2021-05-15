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

    public static void main(String[] args) {
        Daily daily = new Daily();
        int result = daily.romanToInt("III");
        System.out.println(result);
    }

}
