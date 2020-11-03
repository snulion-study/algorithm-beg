package source.backjoon;

import java.util.Scanner;

public class Prob18511 {
    static int num;
    static int target;
    static int[] arr;
    static int[] result;
    static int max = 0;

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        target = stdIn.nextInt();
        num = stdIn.nextInt();
        arr = new int[num + 1];
        result = new int[(int)(Math.log10(target)+1)];

        for(int i = 0; i <num; i++)
            arr[i] = stdIn.nextInt();
        arr[num] = 0;

        find(0);
        System.out.println(max);
    }

    static void find(int depth){
        if(depth == result.length){
            int res = arrayToInt();
            if(res <= target && res > max)
                max = res;
            return;
        }
        if(depth == 0){
            for(int i = 0; i<num+1; i++) {
                result[depth] = arr[i];
                find(depth + 1);
            }
        } else{
            for(int i = 0; i<num; i++) {
                result[depth] = arr[i];
                find(depth + 1);

            }
        }
    }

    static int arrayToInt(){
        StringBuilder s = new StringBuilder();
        for (int i : result) {
            s.append(i);
        }
        return Integer.parseInt(s.toString());
    }
}
