import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Prob6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        while (true) {
            int elements = Integer.parseInt(stk.nextToken());

            if (elements == 0) {            // 집합 S의 원소 개수가 0일 경우 프로그램 종료
                break;
            }

            int[] numChoice = new int[elements];

            for (int i = 0; i < elements; i++) {            // 배열 생성(집합 S)
                numChoice[i] = Integer.parseInt(stk.nextToken());
            }

            stk = new StringTokenizer(br.readLine());
        }
    }

}
