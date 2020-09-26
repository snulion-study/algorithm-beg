package baekjoon;
import java.util.Scanner;

public class num2577 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int A = stdIn.nextInt();
		int B = stdIn.nextInt();
		int C = stdIn.nextInt();
		int mul = A * B * C;
		int length = (int)(Math.log10(mul)+1); // 자릿수 구하기 
		int[]numArray = new int[10];
		
		for(int i = 1; i <= length ; i++) {
			int number = mul % 10;
			mul /= 10;
			numArray[number]++;
		}
		
		for (int i = 0; i < 9 ; i++)
			System.out.println(numArray[i]);	
	}

}
