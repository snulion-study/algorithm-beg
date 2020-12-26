import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Prob14411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> location = new HashSet<>();
        int[] max = new int[]{0, 0};

        for (int i = 0; i < N; i++) {
            String[] ret = br.readLine().split(" ");
            int width = Integer.parseInt(ret[0]) / 2;
            int height = Integer.parseInt(ret[1]) / 2;
            if (width <= max[0] && height <= max[1]) {
                continue;
            } else {
                max[0] = width;
                max[1] = height;
            }

            for (int j = 1; j <= height; j++) {
                for (int h = 1; h <= width; h++) {
                    location.add(Integer.toString(j) + Integer.toString(h));
                }
            }
        }
        System.out.println(location.size() * 4);
    }
}
