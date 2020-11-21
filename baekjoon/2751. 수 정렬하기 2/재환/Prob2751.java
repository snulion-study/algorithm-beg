import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2751 {
    static int[] buff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, N);

        StringBuilder sb = new StringBuilder();

        for (int n : arr) {
            sb.append(n);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void mergeSort(int[] arr, int n) {
        buff = new int[n];

        mergeSortHelper(arr, 0, n - 1);

        buff = null;
    }

    static void mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int addBuffIdx = 0;         // p
            int resultBuffIdx = 0;      // j
            int resultIdx = left;       // k

            mergeSortHelper(arr, left, center);
            mergeSortHelper(arr, center + 1, right);

            for (i = left; i <= center; i++) {
                buff[addBuffIdx++] = arr[i];
            }

            while (i <= right && resultBuffIdx < addBuffIdx) {
                if (buff[resultBuffIdx] <= arr[i]) {
                    arr[resultIdx++] = buff[resultBuffIdx++];
                }
                else {
                    arr[resultIdx++] = arr[i++];
                }
            }

            while (resultBuffIdx < addBuffIdx) {
                arr[resultIdx++] = buff[resultBuffIdx++];
            }
        }
    }

}
