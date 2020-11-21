package Algorithmstudy;
import java.util.Scanner;

public class Problem11651 {
	
	static int maxY;
	static int minY;
	
	static void findMaxMin(int[] a) {
		maxY=a[0];
		minY=a[0];
		for(int i=1;i<a.length;i++) {
			if (a[i]>maxY) maxY=a[i];
			if (a[i]<minY) minY=a[i];
		}
	}
	
	static void fSort(int[] coX, int[] coY) {
		Problem11651.findMaxMin(coY);
		int n=coY.length;
		if(minY<0) {
			int[] f = new int[maxY-minY+1];
			int[] b = new int[n];
			int[] c = new int[n];

			for (int i=0; i<n; i++) f[coY[i]-minY]++; 
			for (int i=1; i<=maxY-minY; i++) f[i] += f[i-1]; 
			for (int i=n-1; i>=0; i--) {
					b[--f[coY[i]-minY]] = coY[i];
					c[f[coY[i]-minY]] = coX[i];
					
			}
			coY[n-1] =b[n-1];
			coX[n-1] =c[n-1];
			for (int i=0; i<n-1; i++) {
				coY[i] =b[i];
				int temp;
				if(coY[i]==coY[i+1] && coX[i]>coX[i+1]) {
					temp=coX[i];
					coX[i]=coX[i+1];
					coX[i+1]=temp;
				}
				else coX[i] =c[i];
			}

		}
		
		else {
			int[] f = new int[maxY+1]; 
		    int[] b = new int[n]; 
		    int[] c = new int[n];
		    
		    for (int i=0; i<n; i++) f[coY[i]]++; 
		    for (int i=1; i<=maxY; i++) f[i] += f[i-1]; 
		    for (int i=n-1; i>=0; i--) {
		    	b[--f[coY[i]]] = coY[i]; 
		    	c[f[coY[i]]] = coX[i];
		    }
			coY[n-1] =b[n-1];
			coX[n-1] =c[n-1];
		    for (int i=0; i<n-1; i++) {
		    	coY[i] =b[i];
		    	int temp;
				if(coY[i]==coY[i+1] && coX[i]>coX[i+1]) {
					temp=coX[i];
					coX[i]=coX[i+1];
					coX[i+1]=temp;
				}
				else coX[i] =c[i];
		    }
		}
	}
		

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner stdIn = new Scanner(System.in);
			int nx= stdIn.nextInt();
			int[] x= new int[nx];
			int[] y= new int[nx];
			
			for (int i=0;i<nx;i++) {
				x[i]= stdIn.nextInt();
			}
			
			for (int i=0;i<nx;i++) {
				y[i]= stdIn.nextInt();
			}

			
			fSort(x, y);
			System.out.println(minY);
			
			for (int i=0;i<nx;i++) {
				System.out.print(x[i]);
				System.out.print(",");
				System.out.println(y[i]);
			}
		
		}
		

}
