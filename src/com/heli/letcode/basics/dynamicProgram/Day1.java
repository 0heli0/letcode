package com.heli.letcode.basics.dynamicProgram;

/**
 * @Author: YourName
 * @Date: 2021/5/10
 */
public class Day1 {
    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return fibonacci(n, 1, 1);
    }

    private static int fibonacci(int n, int a, int b) {
        if (n <= 1) {
            return b;
        }
        return fibonacci(n - 1, b, a + b);
    }

    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;
        int maxPro = 0;//记录最大利润
        int min = 0;//记录数组中访问过的最小值
        for (int i = 1; i < prices.length - 1; i++) {

            if (prices[i] < prices[i + 1] && min == 0) {
                min = prices[i];
            }
            if (prices[i] > prices[i + 1] && min > 0) {
                maxPro += (prices[i] - min);
                min = 0;
            }

            if (i == prices.length - 2 && min > 0) {
                maxPro += (prices[i + 1] - min);
            }
        }
        return maxPro;

    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur, 0) + nums[i];
            max = Math.max(max, cur);
        }

        return max;
    }


    public static int rob(int[] nums) {
        //边界条件判断
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int dp0 = 0;//第1家没偷
        int dp1 = nums[0];//第1家偷了
        //从第2个开始判断
        for (int i = 1; i < length; i++) {
            //防止dp0被修改之后对下面运算造成影响，这里
            //使用一个临时变量temp先把结果存起来，计算完
            //之后再赋值给dp0.
            int temp = Math.max(dp0, dp1);
            dp1 = dp0 + nums[i];
            dp0 = temp;
        }
        //最后取最大值即可
        return Math.max(dp0, dp1);
    }

    public static void main(String[] args) {
        int result = rob(new int[]{1,8,9,7,1,1,7,9,5,1});
        System.out.println(result);
    }

}
