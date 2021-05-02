package com.heli.letcode.basics.str;

import java.util.Arrays;

/**
 * @Author: YourName
 * @Date: 2021/4/30
 */
public class Day1 {
    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = temp;
        }
        System.out.println(Arrays.toString(s));
    }

    public static int reverse(int x) {
        boolean f = false;
        if (x < 0) {
            x = -x;
            f = true;
        }
        int y = 0;
        int len = String.valueOf(x).length();
        while (x > 0) {
            y = (int) (y + x % 10 * Math.pow(10, len - 1));
            x = x / 10;
            len--;
        }
        if (f) {
            return -y;
        }

        if (y <= Integer.MIN_VALUE || y >= Integer.MAX_VALUE) {
            return 0;
        }


        return y;
    }

    public static void main(String[] args) {
//        reverseString(new char[]{'1', '2', '3', '2', '5', '7'});
        System.out.println(reverse(1534236469));
    }
}
