import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        printStar(size);
    }

    static void printStar(int size) {
        for (int i = 0; i < 4; i++) {
            printStar(size / 3);
        }
        for (int i = 0; i < size / 3; i++) {
            
        }
        for (int i = 0; i < 4; i++) {
            printStar(size / 3);
        }
    }
}
