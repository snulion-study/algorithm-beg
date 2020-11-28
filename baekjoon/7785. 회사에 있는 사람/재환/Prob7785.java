import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prob7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> corp = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String name = stk.nextToken();
            String inOut = stk.nextToken();

            switch (inOut) {
                case "enter":
                    corp.add(name);
                    break;
                case "leave":
                    corp.remove(name);
                    break;
            }
        }

        List<String> arrList = new ArrayList<>(corp);
        Collections.sort(arrList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for (String s : arrList) {
            System.out.println(s);
        }
    }
}
