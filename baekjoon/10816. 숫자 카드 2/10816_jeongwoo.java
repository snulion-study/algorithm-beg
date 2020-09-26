package search;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class No10816 {
    private static int size;

    public static void delete(int[] arrs, int index) {
        for (int i = index; i < size - 1; i++) {
            arrs[i] = arrs[i+1];
        }
        size--;
    }

    // arr에서 key 값의 갯수를 result[idx]에 담는 하나씩 찾을 때마다 그 값을 삭제한다.
    public static void binarySearch(int[] arr, int key) {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        int start = 0;
        int end = size - 1;
        int cnt = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                cnt++;
                delete(arr, mid);
                end -= 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.print(cnt + " ");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        size = stdIn.nextInt(); // 상근이가 가지고 있는 숫자 카드의 개수
        int[] cards = new int[size]; // 상근이가 가지고 있는 숫자 카드에 쓰여 있는 숫자
        for (int i = 0; i < size; i++) cards[i] = stdIn.nextInt();

        Arrays.sort(cards); // 이진 검색을 하기 위한 배열 정렬

        int numOfCard = stdIn.nextInt(); // 찾을 카드의 수
        int[] cardToFind = new int[numOfCard]; // 찾을 카드에 쓰여 있는 숫자
        for (int i = 0; i < numOfCard; i++) {
            cardToFind[i] = stdIn.nextInt();
            binarySearch(cards, cardToFind[i]);
        }
    }
}
