package sorting;

import java.util.Scanner;
import java.util.Stack;

public class No1181 implements Comparable<String> {
    static int n;
    @Override
    public int compareTo(String o) {
        return this.compareTo(o);
    }

    static void swap(String[] arr, int id1, int id2) {
        if (arr[id1].equals(id2)) return;
        String temp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = temp;
    }

    static void deleteDupli(String[] arr, int idx) {
        for (int i = idx; i < n-1; i++) {
            arr[i] = arr[i+1];
        }
        n--;
    }

    static void quick(String[] arr, int left, int right) {
        Stack lstack = new Stack<Integer>();
        Stack rstack = new Stack<Integer>();

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = (int) lstack.pop();
            int pr = right = (int) rstack.pop();
            String x = arr[(left + right) / 2];
            do {
                while (arr[pl].length() <= x.length()) {
                    if (arr[pl].length() == x.length()) {
                        if (arr[pl].compareTo(x) < 0) pl++;
                        else break;
                    }
                    else pl++;
                }
                while (arr[pr].length() >= x.length()) {
                    if (arr[pr].length() == x.length()) {
                        if (arr[pr].compareTo(x) > 0) pr--;
                        else break;
                    }
                    else pr--;
                }
                if (pl <= pr) swap(arr, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }
        for (int i = 0; i < n-1 ; i++) {
            while(arr[i].equals(arr[i+1]) && (i+1) < n) deleteDupli(arr, i);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        n = stdIn.nextInt();
        String[] strArr = new String[n];

        for (int i = 0; i < n; i++) strArr[i] = stdIn.next();
        quick(strArr, 0, n-1);
        for (int i = 0; i < n; i++) System.out.println(strArr[i]);
    }
}
