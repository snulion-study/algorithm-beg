package source.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Prob14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numline = br.readLine();
        int numn = Integer.parseInt(numline.split(" ")[0]);
        int numm = Integer.parseInt(numline.split(" ")[1]);

        HashSet set = new HashSet();
        for(int i = 0; i < numn; i++){
            set.add(br.readLine());
        }
        int count = 0;
        for(int i = 0; i <numm; i++){
            if(set.contains(br.readLine()))
                count++;
        }

        System.out.println(count);

    }
}
