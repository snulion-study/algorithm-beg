package source.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Prob1920 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] baseArr = new int[scan.nextInt()];
        for(int i= 0; i<baseArr.length; i++){
            baseArr[i] = scan.nextInt();
        }
        Arrays.sort(baseArr);
        int num = scan.nextInt();
        for(int i = 0; i<num; i++){
            if(binarySearch(baseArr, scan.nextInt())){
                System.out.println(1);
            } else{
                System.out.println(0);
            }
        }
    }

    public static boolean binarySearch(int[] arr, int target){
        int length = arr.length;
        int al= 0;
        int ar = length-1;
        boolean result = false;

        while(al<=ar){
            int ac = (al+ar)/2;
            if(arr[ac] == target){
                result = true;
                break;
            }
            if(arr[ac] > target){
                ar = ac-1;
            } else if(arr[ac] < target){
                al = ac+1;
            }
        }

        return result;
    }
}
