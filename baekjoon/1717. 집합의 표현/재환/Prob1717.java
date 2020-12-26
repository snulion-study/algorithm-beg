import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Prob1717 {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());



        /*Set<Set<Integer>> intSet = new HashSet<>();

        for (int i = 0; i <= N; i++) {
            Set<Integer> eachInt = new HashSet<>();
            eachInt.add(i);
            intSet.add(eachInt);
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            Iterator<Set<Integer>> it = intSet.iterator();

            switch (operator) {
                case 0:
                    Set<Integer> aSet = new HashSet<>();
                    Set<Integer> bSet = new HashSet<>();
                    while (it.hasNext()) {
                        Set<Integer> eachSet = it.next();
                        if (eachSet.contains(a)) {
                            aSet = eachSet;
                        }
                        if (eachSet.contains(b)) {
                            bSet = eachSet;
                        }
                        if (aSet.size() != 0 && bSet.size() != 0) {
                            break;
                        }
                    }
                    intSet.remove(aSet);
                    intSet.remove(bSet);
                    aSet.addAll(bSet);
                    intSet.add(aSet);
                    break;
                case 1:
                    Set<Integer> targetSet = new HashSet<>();
                    while (it.hasNext()) {
                        Set<Integer> eachSet = it.next();
                        if (eachSet.contains(a)) {
                            targetSet = eachSet;
                        }
                    }
                    if (targetSet.contains(b)) {
                        if (i != M - 1) {
                            sb.append("YES").append("\n");
                        } else {
                            sb.append("YES");
                        }
                    } else {
                        if (i != M - 1) {
                            sb.append("NO").append("\n");
                        } else {
                            sb.append("NO");
                        }
                    }
                    break;
            }
        }
        br.close();
        System.out.println(sb);*/
    }
}
