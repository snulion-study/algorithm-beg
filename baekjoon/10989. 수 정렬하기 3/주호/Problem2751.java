package Algorithmstudy;
import java.util.Scanner;

public class Problem2751 {
	static int max;
	static int min;
	
	static void findMaxMin(int[] a) {
		Problem2751.max=a[0];
		Problem2751.min=a[0];
		for(int i=1;i<a.length;i++) {
			if (a[i]>Problem2751.max) Problem2751.max=a[i];
			if (a[i]<Problem2751.min) Problem2751.min=a[i];
		}
	}
	
	static void fSort(int[] a) {
		Problem2751.findMaxMin(a);
		int n=a.length;
		if(Problem2751.min<0) {
			int[] f = new int[Problem2751.max-Problem2751.min+1];
			int[] b = new int[n];
		

			for (int i=0; i<n; i++) f[a[i]-Problem2751.min]++; 
			for (int i=1; i<=Problem2751.max-Problem2751.min; i++) f[i] += f[i-1]; 
			for (int i=n-1; i>=0; i--) {
					b[--f[a[i]-Problem2751.min]] = a[i];
					
			}
			for (int i=0; i<n; i++) a[i] =b[i];
		}
		
		else {
			int[] f = new int[max+1]; 
		    int[] b = new int[n]; 
		    
		    for (int i=0; i<n; i++) f[a[i]]++; 
		    for (int i=1; i<=max; i++) f[i] += f[i-1]; 
		    for (int i=n-1; i>=0; i--) b[--f[a[i]]] = a[i]; 
		    for (int i=0; i<n; i++) a[i] =b [i];
		}
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		int nx= stdIn.nextInt();
		int[] x= new int[nx];
		
		for (int i=0;i<nx;i++) {
			x[i]= stdIn.nextInt();
		}
		

		
		fSort(x);
		
		System.out.println(min);
		System.out.println(max);
		
		for (int i=0;i<nx;i++) {
			System.out.println(x[i]);
		}
	
	}

}
