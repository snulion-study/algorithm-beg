package source.backjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class Prob2164 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> que = new LinkedList<>();
        int num = scan.nextInt();

        for(int i = 1; i <=num; i++){ //순서대로 Card 쌓기
            que.addLast(i);
        }

        while(que.size() != 1){ // 카드의 개수가 1일때까지 반복
            que.removeFirst(); // '제일 위에 있는 카드를 버린다'
            que.addLast(que.removeFirst()); // '제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다'
        }

        System.out.println(que.get(0)); // 마지막으로 뽑는 카드

    }
}
