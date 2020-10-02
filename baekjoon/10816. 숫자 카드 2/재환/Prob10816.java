import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob10816 {
    public static void main(String[] args) throws IOException {

        // BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 배열 생성
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        // 두번째 배열 생성
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(arr1);

        // Stringbuilder 생성
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(arr1, arr2[i])).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int binarySearch(int[] arr, int key) {
        int f = 0;
        int b = arr.length - 1;
        int cnt = 0;

        while (f <= b) {
            int idx = (f + b) / 2;
            if (arr[idx] == key) {
                cnt++;
                for (int i = idx; i > f; i--) {
                    if (arr[i - 1] < key) {
                        break;
                    }
                    cnt++;
                }
                for (int i = idx; i < b; i++) {
                    if (arr[i + 1] > key) {
                        break;
                    }
                    cnt++;
                }
                return cnt;
            }
            if (arr[idx] < key) {
                f = idx + 1;
                continue;
            }
            if (arr[idx] > key) {
                b = idx - 1;
            }
        }
        return 0;
    }
}
