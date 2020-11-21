import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob13415 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int elements = Integer.parseInt(br.readLine());
        int[] arr = new int[elements];

        for (int i = 0; i < elements; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sets = Integer.parseInt(br.readLine());
        int[][] set = new int[sets][2];

        for (int i = 0; i < sets; i++) {
            String[] s = br.readLine().split(" ");
            int UP = Integer.parseInt(s[0]);
            int DOWN = Integer.parseInt(s[1]);
            set[i][0] = UP;
            set[i][1] = DOWN;
        }


    }
}
