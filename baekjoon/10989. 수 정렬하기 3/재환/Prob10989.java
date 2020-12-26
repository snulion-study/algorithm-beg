import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] intArr = new int[N];
        for (int i = 0; i < N; i++) {
            intArr[i] = Integer.parseInt(br.readLine());
        }

        heapSort(intArr, N);

        StringBuilder sb = new StringBuilder();

        for (int n : intArr) {
            sb.append(n);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void downHeap(int[] a, int left, int right) {
        int temp = a[left];
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
            if (temp >= a[child]) break;
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            downHeap(a, i , n - 1);
        }

        for (int i = n -1; i > 0; i--) {
            swap(a, 0, i);
            downHeap(a, 0, i - 1);
        }
    }
}
