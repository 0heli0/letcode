package com.heli.letcode.basics.chars;

import java.util.*;

/**
 * @Author: YourName
 * @Date: 2021/4/29
 */
public class Day2 {
    public static void rotate(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return;
        }

        int[] tmpArray = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            int step = (i + k) % nums.length;
            nums[step] = tmpArray[i];
        }

        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        //把集合list转化为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }

        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static int[] moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == 0){
                int j = i;
                while (j < nums.length-1){
                    if(nums[j++] != 0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        j = nums.length;
                    }else {
                        j++;
                    }

                }
                nums[i+1] = 0;
            }
        }
        return nums;
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i!=map.get(nums[i])){
                return new int[]{i,map.get(nums[i])};
            }
            map.put(target-nums[i], i);
        }
        return new int[]{};
    }
    
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{1,0,2,0,3},5);
        System.out.println(Arrays.toString(result));
    }
}
