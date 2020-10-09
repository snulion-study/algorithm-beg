package chap03;
import java.util.Arrays;
import java.util.Scanner;

class prob1920 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
	
		int num = stdIn.nextInt();
		int[] A = new int[num]; // 요솟수가 num개인 배열! 
		for (int i = 0; i < num; i++) {
			A[i] = stdIn.nextInt();
		}
		
		Arrays.sort(A); //A를 오름차순 배열  
		
		int checknum = stdIn.nextInt(); 
		int [] check = new int[checknum];
		for (int i = 0; i < checknum; i++) {
			check[i] = stdIn.nextInt();
		}
		
		for (int i = 0; i < checknum; i++) {
			int ky = check[i];
			int idx = Arrays.binarySearch(A,  ky);
			
			if(idx<0)
				System.out.println(0);
			else
				System.out.println(1);
		}
	}
}
