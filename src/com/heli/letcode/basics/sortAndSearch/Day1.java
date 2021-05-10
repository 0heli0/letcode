package com.heli.letcode.basics.sortAndSearch;

import java.util.Arrays;

/**
 * @Author: YourName
 * @Date: 2021/5/10
 */
public class Day1 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                tmp[index] = nums1[index1];
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                tmp[index] = nums2[index2];
                index2++;
            }
            index++;
        }

        for (; index1 < m; ) {
            tmp[index++] = nums1[index1++];
        }

        for (; index2 < n; ) {
            tmp[index++] = nums2[index2++];
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = tmp[i];
        }
        Arrays.toString(nums1);
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }
}
