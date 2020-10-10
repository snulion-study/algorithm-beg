// 오류

package chap04;
import java.util.Scanner;
import java.util.LinkedList;

public class prob1021 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int N = stdIn.nextInt(); // 큐의 크기  
		int M = stdIn.nextInt(); // 뽑아내려고 하는 수의 개수
		int cnt = 0; // 2번, 3번 연산의 최솟값
		
		int[] arr = new int[M]; 
		for(int i=0; i<M; i++) {
			arr[i] = stdIn.nextInt(); // 뽑아내려고 하는 수의 위치 순서대로 갖는 array 생성 
		}
		
		LinkedList<Integer> list = new LinkedList<Integer>(); // list라는 큐 생성  
		for(int i=1; i<=N; i++) {
			list.add(i); //순서대로  
		}
		
		for(int i=0; i<M ; i++) { // M개 뽑으므로 M번 반복하면 됨.
		
			// 현재 리스트의 값 = 뽑아내려는 값일 경우  
			if(arr[i] == list.peek()) {
				list.remove();
				continue;
			}
		
			else {
				do {
					if(list.indexOf(arr[i]) <= list.size()/2 ) {
						// 왼쪽으로 한칸씩 밀기 - 현재값 제거하고 마지막에 넣기
						int goleft = list.remove();
						list.add(goleft);
						cnt++;
					}
					
					else {
						// 오른쪽으로 한칸씩 밀기 -> 마지막  값 제거하고 처음에 넣기  
						int goright = list.remove(list.size()-1);
						list.add(0, goright); //처음에 값 넣는 법  
						cnt++;
					}
				
				} while(arr[i] != list.peek());
			}
			
		}
		System.out.println(cnt);
	}
}
		
// 아이디어
// 현재 리스트의 값이 뽑아내려는 값일 때: list.remove()
// list 사이즈의 반보다 작을 때는 2번 활용(왼쪽으로 이동). list 사이즈의 반보다 클 때는 3번 활용(오른쪽으로 이동)....	
