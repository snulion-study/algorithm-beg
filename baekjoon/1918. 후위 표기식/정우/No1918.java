package stack;

import java.util.Scanner;
import java.util.Stack;

public class No1918 {
    public static int orderOfProperty(char s) {
        if (s == '+' || s == '-') return 1;
        else if (s == '*' || s == '/') return 2;
        else if (s == '/') return 0;
        else return -1;
    }

    public static void main(String[] args) {
        /*
        1. 문자는 그냥 출력한다.
        2. 기호가 나왔을 때 스택이 비어 있다면 push 한다.
        3. 스택이 비어 있지 않다면 스택 제일 위의 연산 기호와 비교하여 현재 연산 기호의 우선 순위가 높다면 push하고 그렇지 않다면 pop한 후에 push 한다.
        4. 문자를 모두 출력 했으면 스택이 빌 때까지 pop 한다.
        5. 닫힌 기호가 나오면 열린 기호가 나올 때까지 pop 한다.
         */
        Scanner stdIn = new Scanner(System.in);
        String infix = stdIn.nextLine();
        char[] infixChar = infix.toCharArray();
        Stack stk = new Stack();

        for (int i = 0; i < infixChar.length; i++) {
            if (65 <= infixChar[i] && infixChar[i] <= 90) System.out.print(infixChar[i]);
            else if (stk.empty()) {
                stk.push(infixChar[i]);
            }
            else {
                if (infixChar[i] == ')') {
                    while (true) {
                        if ((char)stk.peek() == '(') {
                            stk.pop();
                            break;
                        }
                        System.out.print(stk.pop());
                    }
                } else if (orderOfProperty(infixChar[i]) > orderOfProperty((char)stk.peek()) || infixChar[i] == '(') {
                    stk.push(infixChar[i]);
                } else {  // (orderOfProperty((char)stk.peek()) >= orderOfProperty(infixChar[i]))
                    System.out.print(stk.pop());
                    stk.push(infixChar[i]);
                }
            }
        }
        while(!stk.empty()) System.out.print(stk.pop());
    }
}
