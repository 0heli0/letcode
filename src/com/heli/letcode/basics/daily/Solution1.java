package com.heli.letcode.basics.daily;


/**
 * @Author: YourName
 * @Date: 2021/5/14
 */
public class Solution1 {
    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        int len = 10;
        int subNum = num;
        while (len <= num) {
            // 获取最后一个数字
            int temp = subNum % 10;
            //将temp转为罗马数字
            str.insert(0, intToRomanUtil(temp, len / 10));
            subNum = subNum / 10;
            len *= 10;
        }
        // 个位数
        str.insert(0, intToRomanUtil(subNum, len / 10));
        return str.toString();
    }

    /**
     * 将数字转换成罗马数字
     *
     * @param num  数字
     * @param type 位数
     */
    private String intToRomanUtil(int num, int type) {
        StringBuilder str = new StringBuilder();
        if (num == 1 || num == 4 || num == 5 | num == 9) {
            return getRoman(num * type);
        } else if (num - 5 > 0) {
            str.append(getRoman(5*type));
            for (int i = 0; i < num - 5; i++) {
                str.append(getRoman(type));
            }

        }else {
            for (int i = 0; i < num; i++) {
                str.append(getRoman(type));
            }
        }


        return str.toString();

    }

    private String getRoman(int num) {
        switch (num) {
            case 1:
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
        }

        return "";
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        /*
         * 1257 MCCLVII
         */
        String result = solution.intToRoman(11);
        System.out.println(result);
    }
}
