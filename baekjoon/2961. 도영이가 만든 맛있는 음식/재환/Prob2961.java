import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2961 {
    public static int[][] taste;
    public static int materials;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        materials = Integer.parseInt(br.readLine());
        taste = new int[materials][2];

        for (int i = 0; i < materials; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(stk.nextToken());
            taste[i][1] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < taste.length; i++) {
            System.out.print("[" + taste[i][0] + ", " + taste[i][1] + "]");
        }

        calculate();
    }

    public static void calculate(int n) {

    }

}
