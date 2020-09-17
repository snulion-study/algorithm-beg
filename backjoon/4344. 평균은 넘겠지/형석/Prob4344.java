package source.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] strarr = new String[Integer.parseInt(br.readLine())][];
        for(int i = 0; i<strarr.length; i++){
            strarr[i] = br.readLine().split(" ");
        }

        int sum;
        double ave;
        int count;

        for(int i = 0; i<strarr.length; i++){
            sum = 0;
            count = 0;
            for(int j = 1; j<strarr[i].length; j++){
                sum += Integer.parseInt(strarr[i][j]);
            }
            ave = (double)sum/Integer.parseInt(strarr[i][0]);

            for(int j = 1; j<strarr[i].length; j++){
                if(Integer.parseInt(strarr[i][j]) > ave){
                    count++;
                }
            }

            System.out.printf("%.3f%%%n", (double)count*100/Integer.parseInt(strarr[i][0]) );
        }

    }
}
