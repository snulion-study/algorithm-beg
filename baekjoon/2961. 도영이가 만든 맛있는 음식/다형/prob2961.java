package chap05;

import java.util.Arrays;
import java.util.Scanner;

public class prob2961 {

	static int N;
	static int[][] taste;
	static int[] diff;
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		N = stdIn.nextInt();
		taste = new int [N][2];
		for(int i=0; i<N; i++) {
			taste[i][0] = stdIn.nextInt(); //신맛  
			taste[i][1] = stdIn.nextInt(); //쓴맛  
		};
		tastecal(1,0);
		Arrays.sort(diff);
		System.out.println(diff[0]);
	}
	
	private static void tastecal(int sour, int bitter) {
		for(int i=0; i<N; i++) {
			int length = diff.length;
			diff[length] = Math.abs(sour*taste[i][0] - (bitter + taste[1][i])) ;
			tastecal(sour*taste[i][0], bitter + taste[i][1]);
			//순서에 관계없이 더해질 수도 있는데 그걸 어떻게 해야 하는지?
			//그리고 지금 이 상태 자체에서 왜 오류가 나는지?
			
		}
	}

}
