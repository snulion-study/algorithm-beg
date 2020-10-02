import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Prob1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받는 중위표기식
        String[] infix = br.readLine().split("");

        Stack<String> oper = new Stack<>();
        String[] postfix = new String[infix.length];

        int idx = 0;
        for (int i = 0; i < infix.length; i++) {
            String compo = infix[i];

            switch (getPriority(compo)) {
                case 4:     // "*" 또는 "/"
                case 3:     // "+" 또는 "-"
                    if (oper.empty()) {
                        oper.push(compo);
                        break;
                    }
                    while (getPriority(oper.peek()) >= getPriority(compo)) {
                        postfix[idx++] = oper.pop();
                        if (oper.empty()) {
                            break;
                        }
                    }
                    oper.push(compo);
                    break;
                case 2:     // "("
                    oper.push(compo);
                    break;
                case 1:     // ")"
                    while(getPriority(oper.peek()) != 2) {
                        postfix[idx++] = oper.pop();
                    }
                    oper.pop();
                    break;
                case 0:     // 문자인 경우
                    postfix[idx++] = compo;
                    break;
            }
        }
        while(!oper.empty()) {
            postfix[idx++] = oper.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            sb.append(postfix[i]);
        }
        System.out.println(sb);
    }

    static int getPriority(String str) {
        switch (str) {
            case "*":
            case "/":
                return 4;
            case "+":
            case "-":
                return 3;
            case "(":
                return 2;
            case ")":
                return 1;
            default:
                return 0;
        }
    }
}
