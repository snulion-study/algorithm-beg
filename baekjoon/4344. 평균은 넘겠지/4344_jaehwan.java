// 재환
import java.util.Scanner;

public class Prob4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        while (test > 0) {
            int students = sc.nextInt();
            int[] score = new int[students];
            double sum = 0;

            for (int i = 0; i < students; i++) {
                score[i] = sc.nextInt();
                sum += score[i];
            }

            double average = sum / students;
            double upper = 0;

            for (int i = 0; i < students; i++) {
                if (score[i] > average) {
                    upper++;
                }
            }
            System.out.printf("%5.3f%%\n", upper / students * 100);
            test--;
        }
    }
}
