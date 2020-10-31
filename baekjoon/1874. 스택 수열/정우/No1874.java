package stack;

import java.util.Scanner;
import java.util.Stack;

public class No1874v2 {
    public static void main(String[] args) {
        Stack s = new Stack();
        int[] arr;
        int cnt;
        Scanner stdIn = new Scanner(System.in);

        // 수열 입력
        cnt = stdIn.nextInt();
        char[] charArr = new char[2 * cnt];
        int cIndex = 0;
        arr = new int[cnt];
        for (int i = 0; i < cnt; i++) arr[i] = stdIn.nextInt();

        /*
        1. 수열의 다음 값이 현재 s.peek()보다 크다면 s.push(curVal++)을 해줘서 arr[i] == s.peek()를 맞춰주고 s.pop() 해서 그걸 꺼내줌.
           s.pop()으로 꺼내진 값들이 수열의 각 요소가 되도록 조절
        2. NO가 되는 경우
            (1) s.peek() > arr[i]인 경우 : pop()으로 나온 모든 값은 수열의 요소가 되어야 하는데 (1)번과 같은 경우가 되면
                                         수열의 요소가 아닌 값들을 pop() 해야 한다.
        3. 스택이 비어 있을 경우 : s.peek()하면 EmptyStackException 오류가 발생하므로 이를 막기 위해서 스택이 비어있으면 값을 하나 넣어준다.
        */


        // 1, 2번 구현
        int curVal = 1;

        for (int i = 0; i < cnt; i++) {
            // 3번 구현
            if (s.empty()) {
                charArr[cIndex++] = '+';
                s.push(curVal++);
            }
            if (arr[i] > (int)s.peek()) {
                while (true) {
                    charArr[cIndex++] = '+';
                    s.push(curVal++);
                    if ( (int)s.peek() == arr[i] ) {
                        charArr[cIndex++] = '-';
                        s.pop();
                        break;
                    }
                }
            } else if (arr[i] == (int)s.peek()) {
                charArr[cIndex++] = '-';
                s.pop();
            } else { // arr[i] < s.peek()
                System.out.println("NO");
                return;
            }
        }

        for (int i = 0; i < charArr.length; i++) System.out.println(charArr[i]);
    }
}
