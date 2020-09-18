package source.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intarr = new int[3];
        int result = 1;
        int[] numarr = {0,1,2,3,4,5,6,7,8,9};
        int[] count = new int[10];

        for(int i = 0; i<3; i++){
            intarr[i] = Integer.parseInt(br.readLine());
            result *= intarr[i];
        }

        for(int i = 0; i<Integer.toString(result).length(); i++){
            count[Character.getNumericValue(Integer.toString(result).charAt(i))]++;
        }

        for(int i = 0; i<10; i++){
            System.out.println(count[i]);
        }

    }
}
