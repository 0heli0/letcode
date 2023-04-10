package com.heli.letcode.basics.daily;

import java.util.HashMap;
import java.util.Map;

public class Day01 {

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
}
