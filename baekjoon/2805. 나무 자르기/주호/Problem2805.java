package hkmooc;
import java.util.Arrays;
public class Problem2805 {
	
	static int cuttingHeight(int[] trees , int need) {
		int height=0;
		int i=1;
		Arrays.sort(trees);
		
		while(i<trees.length) {
			int sum=0;
			for(int j=0;j<i;j++) {
				sum=sum+trees[j];
			}
			
			float answer =(sum-(float)need)/i;
			
			if(answer<=trees[i-1]&&answer>=trees[i]) {
				height=(int) Math.ceil(answer);
				break;
			}
			else
				i++;
		}
		if (height==0.0) {
			int sum=0;
			for(int j=0;j<trees.length;j++) {
				sum=sum+trees[j];
			}
			float answer2 =(sum-(float)need)/trees.length;
			height=(int)Math.ceil(answer2);
		}
		return height;
	}

	public static void main(String[] args) {
		int [] trees= {20,10,17,15};
		int need=62;
		int H= Problem2805.cuttingHeight(trees, need);
		System.out.println(H);

	}

}
