import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Prob13415 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int elements = Integer.parseInt(br.readLine());
        int[] arr = new int[elements];
        String[] element = br.readLine().split(" ");

        for (int i = 0; i < elements; i++) {
            arr[i] = Integer.parseInt(element[i]);
        }

        int sets = Integer.parseInt(br.readLine());

        for (int i = 0; i < sets; i++) {
            String[] s = br.readLine().split(" ");
            int UP = Integer.parseInt(s[0]);
            int DOWN = Integer.parseInt(s[1]);
            mergeSort(arr, new int[arr.length], 0, UP);
            mergeReverseSort(arr, new int[arr.length], 0, DOWN);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer n : arr) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }

    static void mergeSort(int[] arr, int[] temp, int l, int r) {
        int mid = (l + r) / 2;
        if (l == r) return;
        mergeSort(arr, temp, l, mid);
        mergeSort(arr, temp, mid + 1, r);
        for (int i = l; i <= r; i++) {
            temp[i] = arr[i];
        }

        int i1 = l; int i2 = mid + 1;
        for (int curr = l; curr <= r; curr++) {
            if (i1 == mid + 1)
                arr[curr] = temp[i2++];
            else if (i2 > r)
                arr[curr] = temp[i1++];
            else if (temp[i1] < temp[i2])
                arr[curr] = temp[i1++];
            else arr[curr] = temp[i2++];
        }
    }

    static void mergeReverseSort(int[] arr, int[] temp, int l, int r) {
        int mid = (l + r) / 2;
        if (l == r) return;
        mergeReverseSort(arr, temp, l, mid);
        mergeReverseSort(arr, temp, mid + 1, r);
        for (int i = l; i <= r; i++) {
            temp[i] = arr[i];
        }

        int i1 = l; int i2 = mid + 1;
        for (int curr = l; curr <= r; curr++) {
            if (i1 == mid + 1)
                arr[curr] = temp[i2++];
            else if (i2 > r)
                arr[curr] = temp[i1++];
            else if (temp[i1] > temp[i2])
                arr[curr] = temp[i1++];
            else arr[curr] = temp[i2++];
        }
    }

}
