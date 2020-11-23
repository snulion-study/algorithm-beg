import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Prob11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Location[] locations = new Location[N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            locations[i] = new Location(x, y);
        }

        Arrays.sort(locations, new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                if (o1.y > o2.y) {
                    return 1;
                } else if (o1.y == o2.y) {
                    if (o1.x > o2.x) {
                        return 1;
                    } else if (o1.x == o2.x) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Location l : locations) {
            sb.append(l.x);
            sb.append(" ");
            sb.append(l.y);
            sb.append("\n");
        }
        System.out.println(sb);


    }

    static class Location {
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
