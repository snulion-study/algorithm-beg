package source.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Prob1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numline = br.readLine();
        int numa = Integer.parseInt(numline.split(" ")[0]);
        int numb = Integer.parseInt(numline.split(" ")[1]);

        HashSet seta = new HashSet();
        HashSet setb = new HashSet();

        String[] stringa = br.readLine().split(" ");
        String[] stringb = br.readLine().split(" ");

        for(int i = 0; i < stringa.length; i++){
            seta.add(stringa[i]);
        }

        int count = 0;
        for(int i = 0; i< stringb.length; i++){
            if(seta.contains(stringb[i]))
                count++;
        }

        int result = stringa.length + stringb.length - count*2;
        System.out.println(result);
    }
}
