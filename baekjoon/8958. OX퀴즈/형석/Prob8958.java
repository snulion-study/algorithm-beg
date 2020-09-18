package source.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strarr = new String[Integer.parseInt(br.readLine())];

        for(int i = 0; i<strarr.length; i++){
            strarr[i] = br.readLine();
        }

        int point;
        int temp;

        for(int i =0 ; i <strarr.length; i++){
            point = 0;
            temp = 1;
            for(int j = 0; j<strarr[i].length(); j++){
                if(strarr[i].charAt(j) == 'O') {
                    point += temp;
                    temp++;
                } else {
                    temp = 1;
                }
            }
            System.out.println(point);
        }

    }
}
