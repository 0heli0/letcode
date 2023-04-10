package com.heli.letcode.basics;

import com.heli.letcode.basics.daily.Day05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Day05 daily = new Day05();
        int[] result = daily.numMovesStonesII(new int[]{2,24,8,12,56});
        System.out.println(Arrays.toString(result));
    }

}
