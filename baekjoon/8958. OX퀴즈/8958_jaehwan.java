// 재환
import java.util.Scanner;

public class Prob8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        while (test > 0) {
            String result = sc.next();
            int count = 0;
            int sum = 0;

            for (int i = 0; i < result.length(); i++) {
                switch (result.charAt(i)) {
                    case 'O':
                        count++;
                        sum += count;
                        break;
                    case 'X':
                        count = 0;
                        break;
                }
            }
            System.out.println(sum);
            test--;
        }
    }
}
