//package source.backjoon;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Prob2805 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int[] heightArr = new int[scan.nextInt()];
//        int target = scan.nextInt();
//        for(int i = 0; i<heightArr.length; i++){
//            heightArr[i] = scan.nextInt();
//        }
//        Arrays.sort(heightArr);
//
//    }
//
//    public static int binaryS(int[] intArr, int target){
//        int pr = intArr.length-1;
//        int pl = 0;
//
//        while(){
//            int pc = (pr+pl)/2;
//            int sum = 0;
//            for(int i = pc; pc<intArr.length; i++){
//                sum += intArr[i]-intArr[pc];
//            }
//
//            if(sum == target){
//                pr = pc-1;
//            } else if(sum > target){
//                pl = pc +1;
//            } else{
//                pr = pc -1;
//            }
//        }
//    }
//}
