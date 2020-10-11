package chap04;
import java.util.Scanner;
import java.util.LinkedList;

public class prob2164 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		LinkedList<Integer> card = new LinkedList<>();//큐 생성, 최대 N개를 인큐할 수 있는 큐
		
		for (int i=0; i<N; i++) {
			card.add(i+1); // 1부터 N까지 순서대로 인큐  
		}
		
		while(card.size()>1){
			card.remove();
			int x = card.remove();
			card.add(x); // 두 번 deque하고 두 번째로 디큐한 값을 다시 인큐  
		}
		
		int answer = card.poll();
		System.out.println(answer);
	}
}
