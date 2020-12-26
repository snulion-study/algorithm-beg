package hkmooc;
import java.util.Scanner;

public class Problem1874 {
	static int ptr=0;
	static int dataNum=0;
	static int[] sequence;
	static int maxNum;
	static int maxIndex;
	
	public boolean possibility() {
		for (int i=this.maxIndex+1;i<this.maxNum-1;i++) {
			if(this.sequence[i]<this.sequence[i+1])
				return false;
				break;
		}
		return true;
	}
	
	public void printResult() {
		if(this.possibility()) {
			
			for(int i=0;i<this.sequence[0];i++) {
				System.out.println('+');
				this.ptr++;
				this.dataNum++;
			}
			
			System.out.println('-');
			this.dataNum--;
			
			for (int i=1;i<this.maxNum;i++) {
				
				if(ptr==this.maxNum) {
					for(int j=0; j<this.dataNum; j++) {
						System.out.println('-');
					}
					break;
				}
				
				else
					if(this.sequence[i]>this.sequence[i-1]) {
						int interval=this.sequence[i]-this.ptr;
						for(int j=0;j<interval;j++) {
							System.out.println('+');
							this.ptr++;
							Problem1874.dataNum++;
						}
						System.out.println('-');
						Problem1874.dataNum--;
					}
				
					if(this.sequence[i]<this.sequence[i-1]) {
						for(int j=0; j<this.sequence[i-1]-this.sequence[i]; j++) {
							System.out.println('-');
							this.dataNum--;
						}
					}
				}
		}
		
		else
			System.out.println("No");
	}
	
	public static void main(String args[]) {
		
		Scanner stdIn=new Scanner(System.in);
		
		Problem1874 x= new Problem1874();
		
		int n = stdIn.nextInt();
		
		x.maxNum=n;
		
		int [] inputSequence= new int[n];
		
		for(int i=0; i<n; i++) {
			inputSequence[i]=stdIn.nextInt();
			if (inputSequence[i]==n)
				x.maxIndex=i;
		}
		
		x.sequence=inputSequence;
		x.printResult();
	}

}
