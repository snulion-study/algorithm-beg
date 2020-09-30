package hkmooc;
import java.util.Scanner;

public class Problem8958 {
	public static int calcScore(String x) {
		int sum=0;
		int[] y=new int[x.length()];
		for(int i=0; i<x.length(); i++) {
			if('X'==x.charAt(i)) {
				y[i]=0;
			}
			else if ('O'==x.charAt(i) && i==0)
				y[i]=1;
			else
				y[i]=1;
				y[i]=y[i]+y[i-1];
			
		}
		for(int i=0; i<y.length; i++) {
			sum=sum+y[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		String[] a = new String[n];
		int[] b = new int[n];
		for(int i=0; i<n; i++) {
			a[i]= stdIn.nextLine();
		}
		for(int i=0; i<n; i++) {
			b[i]=calcScore(a[i]);
		}
		for(int i=0; i<n; i++) {
			System.out.println(b[i]);
		}
	}

}
