package com.snulion.study.baekjoon;

import java.util.Scanner;

public class Number8958 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int numCase = stdIn.nextInt();

        for (int i = 0; i < numCase; i++) {
            char[] resultForEachQuestion;
            String results = stdIn.next();
            resultForEachQuestion = results.toCharArray();
            int cnt = 0;
            int sum = 0;

            for (int j = 0; j < resultForEachQuestion.length; j++) {
                if (resultForEachQuestion[j] == 'O') {
                    cnt++;
                    sum += cnt;
                }
                if (resultForEachQuestion[j] == 'X') {
                    cnt = 0;
                }
            }
            System.out.println(sum);
        }
    }
}
