package chap05;

import java.util.Arrays;
import java.util.Scanner;

public class prob18511 {
	
	static int N;
	static int K;
	static int[] number;
	static int[] res;

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		N = stdIn.nextInt();
		K = stdIn.nextInt();
		number = new int[K];
		for(int i=0; i < K; i++) {
			number[i] = stdIn.nextInt();
		};
		Arrays.sort(number);
		
		int Nlength = (int)(Math.log10(N)+1);
		int smallest = 0;
		for(int i = 0; i < Nlength; i++) {
			smallest +=  (int) (number[0]*Math.pow(10,i));
		};
		
		if(smallest > N) {
			Nlength = Nlength - 1;
		}
		
		Arrays.sort(res);
		int ans = 0;
		int length = res.length;
		for (int i=length-1; i>0; i--) {
			ans = res[i];
			if(ans<N) break;
		}
		System.out.println(ans);
	}
	
//만들 수 있는 모든 숫자들이어야,,,, 요기 수정 필요 ㅠㅠ 
	private static void largenum(int [] number, int [] res, int Nlength) {
		int nummade = 0;
		for(int j=0; j<number.length; j++) {
			for(int i=0; i<Nlength; i++) {
				nummade = (int) ((int) number[-1-i-j]*Math.pow(10,Nlength-i));
			}
			res[res.length] = nummade;
		}
			
	}

}
