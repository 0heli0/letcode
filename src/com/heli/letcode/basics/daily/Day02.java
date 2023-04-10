package com.heli.letcode.basics.daily;

/**
 * @Author: YourName
 * @Date: 2021/5/14
 */
public class Day02 {
    int val;
    Day02 next;

    Day02() {
    }

    Day02(int val) {
        this.val = val;
    }

    Day02(int val, Day02 next) {
        this.val = val;
        this.next = next;
    }
}
