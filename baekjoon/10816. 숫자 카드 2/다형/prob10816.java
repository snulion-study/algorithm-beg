package chap03;
import java.util.Arrays;
import java.util.Scanner;

class prob10816 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int cardNum = stdIn.nextInt();
		int[] cards = new int[cardNum]; 
		for (int i = 0; i < cardNum; i++) {
			cards[i] = stdIn.nextInt();
		}
		Arrays.sort(cards);
		
		int num = stdIn.nextInt();
		int[] isNum = new int[num]; 
		for (int i = 0; i < num; i++) {
			isNum[i] = stdIn.nextInt();
		}
		
		for (int i = 0; i < num; i++) {
			int sum = 0;
			int ky = isNum[i];
			int idx = Arrays.binarySearch(cards, ky);
			
			if(idx<0) {
				System.out.print(sum + " ");
			}
			else {
				sum = 1;
				for(int k=idx-1; k >= 0 ; k--){ //왼쪽 탐색  
					if(cards[k] == ky)
						sum++;
					else
						break;
				}
				for(int k=idx+1; k < cardNum ; k++){ //오른쪽 탐색  
					if(cards[k] == ky)
						sum++;
					else
						break;
				}
				
				System.out.print(sum + " ");
			}
		}
		
	}

}
