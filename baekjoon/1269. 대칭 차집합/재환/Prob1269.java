import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Prob1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int aCount = Integer.parseInt(stk.nextToken());
        int bCount = Integer.parseInt(stk.nextToken());
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < aCount; i++) {
            setA.add(Integer.parseInt(stk.nextToken()));
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < bCount; i++) {
            Integer newInt = Integer.parseInt(stk.nextToken());
            if (setA.contains(newInt)) {
                setA.remove(newInt);
            } else {
                setB.add(newInt);
            }
        }

        System.out.println(setA.size() + setB.size());
    }
}
