import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Prob10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Stack<Integer> intStack = new Stack<>();

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                intStack.push(num);
            } else {
                intStack.pop();
            }
        }
        int sum = 0;
        while (!intStack.isEmpty()) {
            sum += intStack.pop();
        }
        System.out.println(sum);
    }
}
