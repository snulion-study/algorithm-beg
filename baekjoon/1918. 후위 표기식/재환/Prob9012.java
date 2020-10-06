import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Stack;

public class Prob9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] charArr = new char[n][];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            charArr[i] = str.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            boolean TF = false;
            Stack<Character> stk = new Stack<>();

            for (int j = 0; j < charArr[i].length; j++) {
                switch (charArr[i][j]) {
                    case '(':
                        stk.push(charArr[i][j]);
                        break;
                    case ')':
                        if (stk.empty()) {
                            TF = true;
                            break;
                        }
                        stk.pop();
                        break;
                }
                if (TF) {
                    break;
                }
            }
            if (stk.empty() && !TF) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
