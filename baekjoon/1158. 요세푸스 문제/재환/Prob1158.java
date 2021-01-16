import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Prob1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int personNum = Integer.parseInt(stk.nextToken());
        int order = Integer.parseInt(stk.nextToken());
        LinkedList<Integer> personList = new LinkedList<>();

        for (int i = 0; i < personNum; i++) {
            personList.add(i + 1);
        }

        System.out.print("<");
        int idx = 0;

        while (!personList.isEmpty()) {
            idx = (idx + order - 1) % personList.size();
            if (personList.size() != 1) {
                System.out.print(personList.remove(idx) + ", ");
            }
            else {
                System.out.print(personList.remove(idx));
            }
        }
        System.out.print(">");
    }
}
