// 재환
import java.util.Scanner;

public class Prob2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numA = sc.nextInt();
        int numB = sc.nextInt();
        int numC = sc.nextInt();

        String multiNum = Integer.toString(numA * numB * numC);
        int[] count = new int[10];

        // 배열의 index = 0, 1 ,,, 9
        for (int i = 0; i < multiNum.length(); i++) {
            count[multiNum.charAt(i)-48]++; // 0 : 48, 1 : 49 ...
        }

        // count 한 숫자 출력
        for (int num : count) {
            System.out.println(num);
        }
    }
}
