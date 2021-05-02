package com.heli.letcode.basics.chars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @Author: YourName
 * @Date: 2021/4/28
 */
public class Day1 {
    public static int[] question1(int[] nums){
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[b]){
                nums[++b] = nums[i];
            }
        }
        nums = Arrays.copyOf(nums, b+1);
        return nums;
    }

    public static int question2(int[] nums){
        int profit = 0;
        int index = 0;
        int price = 0;
        boolean isBuy = false;
        while (index < nums.length-1){
            // 买入
            if(!isBuy && (nums[index] < nums[index+1])){
                price = nums[index];
                isBuy = true;
            }
            // 卖出
            if(isBuy &&(nums[index] > nums[index+1]) ){
                profit += (nums[index] - price);
                isBuy = false;
            }

            if(isBuy && index ==  nums.length-2){
                profit += (nums[index+1] - price);
            }
            index++;
        }
        return profit;

    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int length = prices.length;
        //初始条件
        int hold = -prices[0];//持有股票
        int noHold = 0;//没持有股票
        for (int i = 1; i < length; i++) {
            //递推公式转化的
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候利润才会最大，
        //所以这里返回的是noHold
        return noHold;
    }

    public static void main(String[] args) {
        int result = maxProfit(new int[]{1, 4, 6, 8, 10});

        System.out.println(result);
        System.out.println(1^2^4^2);
    }
}
