package source.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Prob7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        HashSet hs = new HashSet();

        for(int i = 0; i < num; i ++){
            String[] str = br.readLine().split(" ");
            String name = str[0];
            String status = str[1];
            if(status.compareTo("enter") == 0)
                hs.add(name);
            else
                hs.remove(name);
        }

        Object[] result = hs.toArray();
        Arrays.sort(result);
        for(int i = result.length-1; i >= 0; i--)
            System.out.println(result[i]);
    }
}
