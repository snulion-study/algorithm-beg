import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        // N 개의 숫자
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());   // 배열 생성
        }

        quickSort(arr, 0, N - 1);
        System.out.println((int) average(arr));         // 산술평균 출력
        System.out.println(arr[N / 2]);                 // 중앙값 출력
        System.out.println(frequency(arr));             // 최빈값 출력
        System.out.println(arr[N - 1] - arr[0]);        // 최댓값과 최솟값의 차이 출력
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int x = arr[(pl + pr) / 2];

        do {
            while (arr[pl] < x) pl++;
            while (arr[pr] > x) pr--;
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) quickSort(arr, left, pr);
        if (pl < right) quickSort(arr, pl, right);
    }

    static double average(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return Math.round(sum / arr.length);
    }

    static int frequency(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int[] fre = new int[]{4001, 4001};        // first, second
        // -2, -2, -1, -1
        int most = 0;
        int idx = 0;

        while (idx < arr.length - 1) {
            int freq = 1;
            while (arr[idx] == arr[++idx]) {
                freq++;
                if (idx == arr.length - 1) {
                    break;
                }
            }

            if (most < freq) {
                fre[1] = 4001;
                fre[0] = arr[idx - 1];
                most = freq;
            }

            // 수정 필요
            else if (most == freq) {
                if (fre[0] > arr[idx - 1]) {
                    fre[1] = fre[0];
                    fre[0] = arr[idx - 1];
                }
                if (fre[1] > arr[idx - 1]) {
                    fre[1] = arr[idx - 1];
                }
            }
        }
        if (fre[1] == 4001) {
            return fre[0];
        }
        return fre[1];
    }
}
