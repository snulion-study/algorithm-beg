import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Prob2805 {
    public static void main(String[] args) throws IOException {
        // BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*// 나무의 수 : N, 필요한 나무 길이 : M
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 나무 높이 설정
        st = new StringTokenizer(br.readLine());

        // 나무 배열 생성
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(maxHeight(tree, m));*/

        while (true) {
            int testN = Integer.parseInt(br.readLine());

            Random rand = new Random();

            int[] testCase = new int[testN];
            for (int i = 0; i < testN; i++) {
                testCase[i] = rand.nextInt(10000);
            }
            int sum = 0;
            Arrays.sort(testCase);
            System.out.print("주어진 배열 : ");
            for (int num : testCase) {
                sum += num;
                System.out.print(num + " ");
            }
            System.out.println();
            while (true) {
                int testM = Integer.parseInt(br.readLine());

                System.out.println("최대 높이 : " + maxHeight(testCase, testM) + "m");
            }
        }
    }

    static int maxHeight(int[] arr, int key) {
        Arrays.sort(arr);
        System.out.print("주어진 배열 : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] diff = new int[arr.length];

        diff[0] = 0;    // 첫번째 요소
        for (int i = 1; i < diff.length; i++) {
            diff[i] = diff[i - 1] + (arr[arr.length - i] - arr[arr.length - i - 1]) * i;
        }
        System.out.print("diff 배열 : ");
        for (int num : diff) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("필요한 길이 : " + key + "m");


        int idx = binarySearch(diff, key);
        int a = (int) Math.ceil((key - diff[idx]) / (float) (idx + 1));
        int maxHeight = arr[arr.length - idx - 1] - a;

        return maxHeight;
    }

    static int binarySearch(int[] arr, int key) {
        int f = 0;
        int b = arr.length - 1;

        while (f <= b) {
            int idx = (f + b) / 2;;
            if (idx == arr.length - 1) {
                return idx;
            }

            if (arr[idx] <= key && arr[idx + 1] > key) {
                return idx;
            }
            if (arr[idx] <= key) {
                f = idx + 1;
                continue;
            }
            if (arr[idx] > key) {
                b = idx - 1;
            }
        }
        return -1;
    }
}
