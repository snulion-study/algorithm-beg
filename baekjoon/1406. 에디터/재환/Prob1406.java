import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().toCharArray();
        LinkedListArr resultString = new LinkedListArr();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length; i++) {
            resultString.tail.prev = new CharNode(string[i], resultString.tail.prev, resultString.tail);
            resultString.tail.prev.prev.next = resultString.tail.prev;
        }
        resultString.curr = resultString.tail.prev;
        int command = Integer.parseInt(br.readLine());
        for (int i = 0; i < command; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            switch (stk.nextToken()) {
                case "L":
                    if (resultString.head != resultString.curr) {
                        resultString.curr = resultString.curr.prev;
                    }
                    break;
                case "D":
                    if (resultString.tail.prev != resultString.curr) {
                        resultString.curr = resultString.curr.next;
                    }
                    break;
                case "B":
                    if (resultString.head != resultString.curr) {
                        resultString.curr.prev.next = resultString.curr.next;
                        resultString.curr.next.prev = resultString.curr.prev;
                        resultString.curr = resultString.curr.prev;
                    }
                    break;
                case "P":
                    char newChar = stk.nextToken().charAt(0);
                    resultString.curr.next = new CharNode(newChar, resultString.curr, resultString.curr.next);
                    resultString.curr.next.next.prev = resultString.curr.next;
                    resultString.curr = resultString.curr.next;
                    break;
            }
        }
        resultString.curr = resultString.head.next;
        while (resultString.curr != resultString.tail) {
            sb.append(resultString.curr);
            resultString.curr = resultString.curr.next;
        }
        System.out.println(sb);
    }

    static class LinkedListArr {
        CharNode head;
        CharNode tail;
        CharNode curr;

        public LinkedListArr() {
            head = curr = new CharNode(null, null);
            tail = new CharNode(null, null);
            head.next = tail;
            tail.prev = head;
        }


    }
    public static class CharNode {
        char data;
        CharNode prev;
        CharNode next;

        public CharNode(CharNode prev, CharNode next) {
            this.prev = prev;
            this.next = next;
        }

        public CharNode(char data, CharNode prev, CharNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + data + "";
        }
    }
}
