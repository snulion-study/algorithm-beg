import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob1920 {
    // BufferedReader는 Exception이 처리를 따로 해줘야 하기 때문에 throws를 해주거나
    // try ~ catch로 예외처리를 해줘야합니다.
    public static void main(String[] args) throws IOException {

        // BufferedReader 객체 생성
        // new InputStreamReader 및 System.in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // String Line이므로 Integer.parseInt를 이용하여 형변환 필요
        int n = Integer.parseInt(br.readLine());

        // "1 3 5 7" 식으로 공란 포함 String Line일시 StringTokenizer 이용
        int[] arr1 = new int[n];

        // st = new StringTokenizer(br.readLine());
        // 두 번째 파라메터가 없는 br.readLine()의 기본형은 공백을 제거한 것을 추출해줌
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            // 배열에다 토큰을 하나씩 불러서 입력해줌
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(arr1, arr2[i])).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int binarySearch(int[] arr, int key) {
        int f = 0;
        int b = arr.length - 1;


        while (f <= b) {
            int idx = (f + b) / 2;
            if (arr[idx] == key) {
                return 1;
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
