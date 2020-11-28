import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Prob1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        st = new StringTokenizer(br.readLine());
        int truthPeopleCount = Integer.parseInt(st.nextToken());
        int[] truthPeopleNum = new int[truthPeopleCount];

        for (int i = 0; i < truthPeopleCount; i++) {
            truthPeopleNum[i] = Integer.parseInt(st.nextToken());
        }

        int tellLie = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyPeople = Integer.parseInt(st.nextToken());
            Set<Integer> peopleSet = new HashSet<>();

            if (partyPeople == 0) {
                tellLie++;
                continue;
            }

            int j;
            for (j = 0; j < partyPeople; j++) {
                peopleSet.add(Integer.parseInt(st.nextToken()));
            }

            if (truthPeopleCount == 0) {
                tellLie++;
                continue;
            }


            for (j = 0; j < truthPeopleCount; j++) {
                if (peopleSet.contains(truthPeopleNum[j])) {
                    break;
                }
            }

            if (j == truthPeopleCount) {
                tellLie++;
            }
        }

        System.out.println(tellLie);
    }
}
