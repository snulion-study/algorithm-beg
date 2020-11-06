package source.backjoon;

import java.util.Scanner;

public class Prob2961 {
    static int num;
    static int[][] arr;
    static int[] res = new int[2];
    static boolean[] flag;
    static int min = 99999;

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        num = stdIn.nextInt();
        arr = new int[num][2];
        flag = new boolean[num];

        for(int i = 0; i < num; i++){
            arr[i][0] = stdIn.nextInt();
            arr[i][1] = stdIn.nextInt();
        }
        cook(0);
        System.out.println(min);
    }

    static void cook(int count){
        if(count == num){
            res[0] = 1;
            res[1] = 0;
            for(int i = 0; i < num; i++){
                if(flag[i]){
                    res[0] *= arr[i][0];
                    res[1] += arr[i][1];
                }
            }
            if(res[0] == 1 && res[1] == 0)
                return;
            int result = Math.abs(res[0]-res[1]);
            if(result < min)
                min = result;
        } else{
            flag[count] = false;
            cook(count+1);
            flag[count] = true;
            cook(count+1);
        }
    }
}
