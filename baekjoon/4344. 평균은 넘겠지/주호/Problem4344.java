package hkmooc;
import java.util.Scanner;

public class Problem1111 {
	
	public static float calcAvg(int[] a) {
		float x=0;
		float avg=0;
		for (int i=0; i<a.length; i++) {
			avg=avg+a[i];
		}
		avg=avg/a.length;
		for (int i=0; i<a.length; i++) {
			if(a[i]>avg) {
				x++;
			}
		}
		x=x/a.length;
		
		return x;
	}
	
	public static void printAvg() {
		Scanner stdIn= new Scanner(System.in);
		int n= stdIn.nextInt();
		float[] result = new float[n];
		for(int i=0; i<n; i++) {
			int m= stdIn.nextInt();
			int[] part = new int[m];
			for(int j=0; j<m; j++) {
				int l= stdIn.nextInt();
				part[j]= l;
			}
			result[i]=calcAvg(part);
		}
		for(int i=0; i<n; i++) {
			System.out.println(result[i]);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n= stdIn.nextInt();
		float[] result = new float[n];
		for(int i=0; i<n; i++) {
			int m= stdIn.nextInt();
			int[] part = new int[m];
			for(int j=0; j<m; j++) {
				int l= stdIn.nextInt();
				part[j]= l;
			}
			result[i]=calcAvg(part);
		}
		for(int i=0; i<n; i++) {
			System.out.println(result[i]*100);
		}
	}

}
