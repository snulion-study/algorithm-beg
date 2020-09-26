package chap03;
import java.util.Arrays;
import java.util.Scanner;

class prob2805 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int treeNum = stdIn.nextInt();
		int need = stdIn.nextInt();
		int[] tree = new int[treeNum];
		for (int i = 0; i < treeNum; i++) {
			tree[i] = stdIn.nextInt();
		}
		Arrays.sort(tree); // 내림차순 배열은 어떻게 ?  
		
		int height = tree[treeNum-1];
		int sum = 0;
		
		for (int i = 0; i < tree[treeNum-1]; i++) {
			for (int k = treeNum - 1; k >= 0; k--) {
				if (tree[k] <= height)
					break;
				sum += tree[k] - height;
			}
			
			if (sum >= need)
				break;
			
			else
				sum = 0;
				height--;
		}
		System.out.println(height);
	}
}
