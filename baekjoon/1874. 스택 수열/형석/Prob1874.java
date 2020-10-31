package source.backjoon;

import java.util.Scanner;
import java.util.Stack;

public class Prob1874 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = scan.nextInt(); // 입력받을 1~n 정수 중 n값.
        int top = 0; // 현재 stack에 어디까지 쌓았는지 나타내는 지표.
        int[] intarr = new int[max]; // 사전 NO 검사를 위하여 intarr를 받아서 검사함.
        Stack<Integer> stk = new Stack<>(); // stack 구조
        int valid = 0;  // input값 중 max값 가지는 index받기 위함.

        for (int i = 0; i < max; i++) {
            intarr[i] = scan.nextInt(); // 숫자를 하나씩 입력받음
            if (intarr[valid] < intarr[i]) {  // 지금까지 나온 수 보다 작은 level에서 오름차순 나오면 실패하니깐 최대값 index 받기
                valid = i;
            }
            if (valid < i && intarr[i] > intarr[i - 1]) { // 최대값 index 보다 큰 범위에서 오름차순 발생하면 거기서 out
                System.out.println("NO");
                return;
            }
        }

        for (int i = 0; i < max; i++) {
            if (intarr[i] > top) { // 기본적으로 push를 할지 pop을 할지 정하는 조건문. 이미 쌓인거보다 더 크면 무조건 push임
                for (int j = top; j < intarr[i]; j++) { // 그 push를 몇개할지 정함.
                    stk.push(j + 1);
                    System.out.println("+");
                }
            } else if (stk.peek() > intarr[i]) { // 지금 stack에 쌓인 값의 maximum보다 input값 작으면 pop으로 빼줌
                for (int j = stk.peek(); j < stk.peek() - intarr[i]; j--) {
                    stk.pop();
                    System.out.println("-");
                }
            }
            System.out.println("-"); // 위에서 target까지 도달했고( 처음에 4같은경우 + 4번 출력, 이줄에서 마지막 한줄 출력)

            if (top < intarr[i]) {
                top = intarr[i];
            }
        }
    }
}


//
//        for(int i = 0; i<=valid; i++){
//            temp = intarr[i];
//            if(temp > top){
//                for(int j = 0; j<temp-top; j++){
//                    System.out.println("+");
//                }
//            } else if (temp < intarr[i-1]){
//                for(int j = 1; j<intarr[i-1]-temp; j++){
//                    System.out.println("-");
//                }
//            }
//
//            if(temp > top){
//                top = temp;
//            }
//
//            System.out.println("-");
//        }
//
//        for(int i = valid + 1 ; i<max; i++){
//            System.out.println("-");
//        }
