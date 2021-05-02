package com.heli.letcode.basics.chars;

import java.util.*;

/**
 * @Author: YourName
 * @Date: 2021/4/30
 */
public class Dya3 {
    /*
     * 0,0 0,3 0,6 3,0 3,3 3,6 6,0 6,3 6,6
     */
    public static boolean isValidSudoku(char[][] board) {

        int length = board.length;
        //二维数组line表示的是对应的行中是否有对应的数字，比如line[0][3]
        //表示的是第0行（实际上是第1行，因为数组的下标是从0开始的）是否有数字3
        int line[][] = new int[length][length];
        int column[][] = new int[length][length];
        int cell[][] = new int[length][length];
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.') continue;

                //num是当前格子的数字
                int num = board[i][j] - '0' - 1;
                //k是第几个单元格，9宫格数独横着和竖着都是3个单元格
                int k = i / 3 * 3 + j / 3;
                //如果当前数字对应的行和列以及单元格，只要一个由数字，说明冲突了，直接返回false。
                //举个例子，如果line[i][num]不等于0，说明第i（i从0开始）行有num这个数字。
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0) {
                    return false;
                }
                System.out.printf("%5d", k);
                //表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
            System.out.println();
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            Set<Character> line = new HashSet<>();
            Set<Character> row = new HashSet<>();
            Set<Character> cell = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && !line.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !row.add(board[j][i])) {
                    return false;
                }

                int a = (i / 3) * 3 + j / 3;
                int b = (i % 3) * 3 + j % 3;
                if (board[a][b] != '.' && !cell.add(board[a][b])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length - 1;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%5s", anInt);
            }

            System.out.println();
        }
        System.out.println("---------------------------------");
//        int a = 0;
//        int b = 0;
//        int c = 0;
//        int d = 0;
        for (int i = 0; i < (length+2)/2; i++) {
            for (int j = i; j < length-i; j++) {
                int a = matrix[i][j];
                int b = matrix[j][length - i];
                int c = matrix[length - i][length - j];
                int d = matrix[length - j][i];
                matrix[j][length - i] = a;
                matrix[length - i][length - j] = b;
                matrix[length - j][i] = c;
                matrix[i][j] = d;

            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%5s", anInt);
            }

            System.out.println();
        }

    }

    public static void main(String[] args) {
        char[][] chars = {
                {'1', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '4', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        int[][] ints = {
                /*
                 * 0,0 0,6
                 * 0,1 1,6
                 * 0,2 2,6
                 *
                 * i = j
                 * j = length - i
                 */
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36},
        };

        rotate(ints);

    }
}
