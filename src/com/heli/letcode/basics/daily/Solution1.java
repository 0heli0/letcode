package com.heli.letcode.basics.daily;


import com.heli.letcode.basics.listNode.ListNode;

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
            str.append(getRoman(5 * type));
            for (int i = 0; i < num - 5; i++) {
                str.append(getRoman(type));
            }

        } else {
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

    public ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
        ListNode1 result = new ListNode1(0);
        ListNode1 temp = result;
        int val1 = 0;
        int val2 = 0;
        int overVal = 0;
        boolean flag1 = true;
        boolean flag2 = true;
        while (flag1 || flag2) {
            val1 = 0;
            val2 = 0;
            if (flag1) {
                val1 = l1.val;
                l1 = l1.next;
            }else {

            }

            if (flag2) {
                val2 = l2.val;
                l2 = l2.next;
            }

            if (val1 + val2 < 10) {
                temp.next = new ListNode1(val1 + val2 + overVal);
                overVal = 0;
            } else {
                System.out.println(val1+","+val2+","+overVal);
                temp.next = new ListNode1(val1 + val2 + overVal - 10);
                overVal = 1;
            }

            temp = temp.next;


            if (l1 == null) {
                flag1 = false;
            }
            if (l2 == null) {
                flag2 = false;
            }

        }
        while (result.next != null){
            System.out.println(result.val);
            result = result.next;
        }
        return result;

    }

    public ListNode1 addTwoNumbers2(ListNode1 l1, ListNode1 l2) {
        ListNode1 pre = new ListNode1(0);
        ListNode1 cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode1(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode1(carry);
        }

        return pre.next;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        /*
         * 1257 MCCLVII
         */
//        String result = solution.intToRoman(11);
//        System.out.println(result);

        //[9,9,9,9,9,9,9]
        //[9,9,9,9]
        ListNode1 l1 = new ListNode1(9);
        l1.next = new ListNode1(9);
        l1.next.next = new ListNode1(9);
        l1.next.next.next = new ListNode1(9);
        l1.next.next.next.next = new ListNode1(9);
        l1.next.next.next.next.next = new ListNode1(9);
        l1.next.next.next.next.next.next = new ListNode1(9);

        ListNode1 l2 = new ListNode1(9);
        l2.next = new ListNode1(9);
        l2.next.next = new ListNode1(9);
        solution.addTwoNumbers(l1, l2);


    }
}
