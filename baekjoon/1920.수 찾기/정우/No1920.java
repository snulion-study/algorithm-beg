package search;

import java.util.Scanner;
import java.util.Arrays;

public class No1920 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int num = stdIn.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) nums[i] = stdIn.nextInt();
        Arrays.sort(nums);

        int numToFind = stdIn.nextInt();
        int[] numsToFind = new int[numToFind];
        for (int i = 0; i < numToFind; i++) {
            numsToFind[i] = stdIn.nextInt();
            System.out.println(binarySearch(nums, num, numsToFind[i]));
        }
    }

    public static int binarySearch(int[] arr, int num, int key) {
        int start = 0;
        int end = num - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}
