package source.backjoon;

import java.util.Scanner;
import java.util.Stack;

public class Prob1918 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        toPostfix(str);
    }
    public static void toPostfix(String infix){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        char[] ch = infix.toCharArray();
        for(int i = 0; i< ch.length ; i++){
            if('A'<= ch[i] && ch[i] <= 'Z'){
                sb.append(ch[i]);
            }
            else{
                switch (ch[i]){
                    case '(':
                        stk.push('(');
                        break;
                    case '*':
                    case '/':
                        while(!stk.isEmpty() && (stk.peek() == '*' || stk.peek() == '/')){
                            sb.append(stk.pop());
                        }
                        stk.push(ch[i]);
                        break;
                    case '+':
                    case '-':
                        while(!stk.isEmpty() && stk.peek()!= '('){
                            sb.append(stk.pop());
                        }
                        stk.push(ch[i]);
                        break;
                    case ')':
                        while(!stk.isEmpty() && stk.peek() != '('){
                            sb.append(stk.pop());
                        }
                        stk.pop();
                        break;
                }
            }
        }
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        System.out.println(sb);
    }
}
