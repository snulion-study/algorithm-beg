import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Prob1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 연산자 표시
        StringBuilder sb = new StringBuilder();

        // 수열 길이 받기
        int n = Integer.parseInt(br.readLine());

        // 수열 생성
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> mkStack = new Stack<>();
        int num;

        for (num = 1; num < seq[0]; num++) {
            mkStack.push(num);
            sb.append("+\n");
        }

        sb.append("+\n");
        sb.append("-\n");
        num++;

        int i;
        for (i = 1; i < n; i++) {
            while (num < seq[i]) {
                mkStack.push(num++);
                sb.append("+\n");
            }
            if (num == seq[i]) {
                sb.append("+\n");
                sb.append("-\n");
                num++;
            } else {
                if (mkStack.pop() != seq[i]) {
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (i == n) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
