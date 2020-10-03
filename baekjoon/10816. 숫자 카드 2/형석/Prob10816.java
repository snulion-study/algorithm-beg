//package source.backjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
////public class Prob10816 {
////    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        int[] arr = new int[20000001];
////        int num1 = Integer.parseInt(br.readLine());
////        String[] strarr = br.readLine().split(" ");
////        for(int i = 0; i<num1; i++){
////            arr[Integer.parseInt(strarr[i])+10000000]++;
////        }
////        int num2 = Integer.parseInt(br.readLine());
////        String[] strarr2 = br.readLine().split(" ");
////        for(int i= 0; i<num2; i++){
////            System.out.print(arr[Integer.parseInt(strarr2[i])+10000000] + " ");
////        }
////    }
////}
//
//public class Prob10816{
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num = Integer.parseInt(br.readLine());
//        String[] baseArr = br.readLine().split(" ");
//        int[] intArr = new int[num];
//        for(int i = 0; i<num ; i++){
//            intArr[i] = Integer.parseInt(baseArr[i]);
//        }
//        Arrays.sort(intArr);
//
//        int num2 = Integer.parseInt(br.readLine());
//        String[] tarArr = br.readLine().split(" ");
//
//        for(int i = 0; i<num2; i++){
//            int low = binSearchX(intArr, Integer.parseInt(tarArr[i]));
//            int high = binSearchY(intArr, Integer.parseInt(tarArr[i]));
//            System.out.printf("%d ", (high == -1)? 0 : high-low+1);
//        }
//    }
//
//    static int binSearchX(int[] arr, int target){
//        int len = arr.length;
//        int pl = 0;
//        int pr = len-1;
//        int pc = 0;
//        int[] result = new int[len];
//        int count = 0;
//
//        do{
//            pc = (pl+pr)/2;
//
//            if(arr[pc] == target){
//                result[count] = pc;
//                count++;
//                pr = pc -1;
//            } else if(arr[pc] > target) {
//                pr = pc - 1;
//            } else if(arr[pc] < target){
//                pl = pc+1;
//            }
//        } while(pr>=pl);
//
//        return (count != 0)? result[count-1] : -1;
//    }
//
//    static int binSearchY(int[] arr, int target){
//        int len = arr.length;
//        int pl = 0;
//        int pr = len-1;
//        int pc = 0;
//        int[] result = new int[len];
//        int count = 0;
//
//        do{
//            pc = (pl+pr)/2;
//
//            if(arr[pc] == target){
//                result[count] = pc;
//                count++;
//                pl = pc + 1;
//            } else if(arr[pc] > target) {
//                pr = pc - 1;
//            } else if(arr[pc] < target){
//                pl = pc+1;
//            }
//        } while(pr>=pl);
//
//        return (count != 0)? result[count-1] : -1;
//    }
//}



//public class Prob10816 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] arr = new int[20000001];
//        int num1 = Integer.parseInt(br.readLine());
//        String[] strarr = br.readLine().split(" ");
//        for (int i = 0; i < num1; i++) {
//            arr[Integer.parseInt(strarr[i]) + 10000000]++;
//        }
//        int num2 = Integer.parseInt(br.readLine());
//        StringBuffer sb = new StringBuffer();
//        String[] strarr2 = br.readLine().split(" ");
//        for (int i = 0; i < num2; i++) {
//            sb.append(arr[Integer.parseInt(strarr2[i]) + 10000000] + " ");
//        }
//        System.out.println(sb);
//    }
//}