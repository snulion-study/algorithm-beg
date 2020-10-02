package hkmooc;
import java.util.Scanner;

public class Problem2577 {
	static int[] countIn(int a, int b, int c) {
		String d= Integer.toString(a*b*c);
		int[] x = new int[10];
		for(int i=0;i<10;i++) {
			int z=0;
			for(int j=0; j<d.length(); j++) {
				 if((char) i+'0'==d.charAt(j)) {
					 z=z+1;
				 }
			}
			x[i]=z;
		}
		return x;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("enter number: ");
		int a= stdIn.nextInt();
		System.out.println("enter number: ");
		int b= stdIn.nextInt();
		System.out.println("enter number: ");
		int c= stdIn.nextInt();
		int[] x= countIn(a,b,c);
		for(int i=0; i<x.length;i++) {
			System.out.println(x[i]);
		}
	}
}
