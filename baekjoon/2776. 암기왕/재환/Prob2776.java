import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prob2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            Set<Integer> note1 = new HashSet<>();
            for (int j = 0; j < N; j++) {
                note1.add(Integer.parseInt(stk.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            Set<Integer> note2 = new LinkedHashSet<>();
            for (int j = 0; j < M; j++) {
                note2.add(Integer.parseInt(stk.nextToken()));
            }

            Iterator<Integer> it = note2.iterator();

            while (it.hasNext()) {
                if (note1.contains(it.next())) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
