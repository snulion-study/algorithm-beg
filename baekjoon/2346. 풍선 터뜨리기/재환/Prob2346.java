import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Prob2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        LinkedList<Integer> balloons = new LinkedList<>();
        LinkedList<Integer> number = new LinkedList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            balloons.add(Integer.parseInt(stk.nextToken()));
            number.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (balloons.size() > 1) {
            int nextIdx = balloons.remove(idx);
            int balloonNum = number.remove(idx);

            if (nextIdx > 0) {
                nextIdx -= 1;
            }

            sb.append(balloonNum).append(" ");
            idx = (idx + nextIdx) % balloons.size();

            if (idx < 0) {
                idx += balloons.size();
            }
        }

        sb.append(number.remove(0));

        System.out.println(sb);
    }
}
