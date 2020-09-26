import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int leng1 = Integer.parseInt(br.readLine());              // 입력받는 배열 길이
        int[] intArr1 = new int[leng1];        // 배열 생성

        // intArr1에 요소 넣기
        for (int i = 0; i < leng1; i++) {
            int element = Integer.parseInt(br.readLine());
            intArr1[i] = element;
        }

        int leng2 = Integer.parseInt(br.readLine());              // 배열 추가 입력
        int[] intArr2 = new int[leng2];

        // intArr2에 요소 넣기
        for (int i = 0; i < leng2; i++) {
            int element = Integer.parseInt(br.readLine());
            intArr2[i] = element;
        }

        for (int i = 0; i < leng2; i++) {
            int j;
            for (j = 0; j < leng1; j++) {
                if (intArr1[j] == intArr2[i]) {
                    System.out.print("1\n");
                    break;
                }
            }
            if (j == leng1) {
                System.out.print("0\n");
            }
        }
    }
}
