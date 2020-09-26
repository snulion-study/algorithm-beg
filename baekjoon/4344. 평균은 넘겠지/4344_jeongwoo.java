package com.snulion.study.baekjoon;

import java.util.Scanner;

public class Number4344 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int numCase = stdIn.nextInt();
        for (int i = 0; i < numCase; i++) {
            int numStudent = stdIn.nextInt();
            int sum = 0;
            int cnt = 0;
            int[] scores = new int[1000];

            for (int j = 0; j < numStudent; j++) {
                scores[j] = stdIn.nextInt();
                sum += scores[j];
            }
            double avr = (double) sum / numStudent;
            for (int j = 0; j < numStudent; j++) {
                if (scores[j] > avr) cnt++;
            }
            System.out.printf("%.3f%c\n", ((double) cnt / (double) numStudent) * 100, '%');
        }
    }
}
