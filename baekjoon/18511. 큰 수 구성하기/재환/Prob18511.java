import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob18511 {

    public static int targetNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(stk.nextToken());
        int elements = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());

        int[] numSet = new int[elements];

        for (int i = 0; i < elements; i++) {
            numSet[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(numSet);
        biggerNum(0, number, numSet);
        System.out.println(targetNum);
    }

    public static void biggerNum(int n, int limNum, int[] numSet) {
        if (n > limNum) {
            return;
        }
        if (targetNum <= n) {
            targetNum = n;
        }

        for (int i = numSet.length - 1; i >= 0; i--) {
            biggerNum(n * 10 + numSet[i], limNum, numSet);
        }
    }
}
