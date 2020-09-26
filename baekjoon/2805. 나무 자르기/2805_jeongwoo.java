package search;

import java.util.Scanner;

public class No2805 {
    public static long sum(int[] arr, int val) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] - val >= 0)
                sum += (arr[i] - val);

        return sum;
    }
    public static int findMaxHeight(int[] heights, int length) {
        int start = 1;
        int max = 0;

        for (int i = 0; i < heights.length; i++) if (max < heights[i]) max = heights[i];
        int end = max;

        while (true) {
            int mid = (start + end) / 2;
            long sumVal = sum(heights, mid);

            if (sumVal == length) return mid;
            else if (sumVal > length) {
                if (sum(heights, mid + 1) < length)
                    return mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int numOfTree = stdIn.nextInt();
        int[] heights = new int[numOfTree];

        int length = stdIn.nextInt();
        for (int i = 0; i < numOfTree; i++) heights[i] = stdIn.nextInt();

        System.out.println(findMaxHeight(heights, length));
    }
}
