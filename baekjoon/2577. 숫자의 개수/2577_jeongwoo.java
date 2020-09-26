package com.snulion.study.baekjoon;

import java.util.Scanner;

public class Number2577 {
    public static void checkEachNum(int[] checkArr, int num1, int num2, int num3) {
        String result = Integer.toString(num1 * num2 * num3);
        char[] charArr = result.toCharArray();
        for (int i = 0; i < result.length(); i++) {
            checkArr[charArr[i] - 48]++;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] checkArr = new int[10];

        int num1 = stdIn.nextInt();
        int num2 = stdIn.nextInt();
        int num3 = stdIn.nextInt();

        checkEachNum(checkArr, num1, num2, num3);

        for(int i = 0; i < 10; i++) System.out.println(checkArr[i]);
    }
}
