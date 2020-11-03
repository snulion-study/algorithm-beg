package source.backjoon;

import java.util.Scanner;

public class Prob6603 {
    static int[] result;
    static boolean[] bool;
    static int[] arr;

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        while(true){
            int num = stdIn.nextInt();
            if(num == 0)
                break;
            arr = new int[num];
            bool = new boolean[num];
            result = new int[6];
            for(int i = 0; i < num; i++)
                arr[i] = stdIn.nextInt();
            lotto(0, 0);
            System.out.println();
        }
    }

    static void lotto(int depth, int start){
        if(depth == 6){
            print();
            return;
        }

        for(int i = start; i< arr.length; i++){
            if(bool[i] == false){
                result[depth] = arr[i];
                bool[i] = true;
                lotto(depth + 1, depth+1);
                bool[i] = false;
            }
        }
    }

    static void print(){
        for(int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
        System.out.println();
    }
}
