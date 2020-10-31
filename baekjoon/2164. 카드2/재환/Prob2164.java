import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Prob2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());     // 정수 N
        Queue<Integer> cardQue = new LinkedList<>();

        for (int i = 1; i <= num; i++) {
            cardQue.add(i);
        }

        while (cardQue.size() != 1) {
            cardQue.remove();
            if (cardQue.size() == 1) {
                System.out.println(cardQue.element());
                return;
            }
            cardQue.add(cardQue.remove());
        }

        System.out.println(cardQue.element());
    }
}
