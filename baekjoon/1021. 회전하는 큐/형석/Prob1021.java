package source.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Prob1021 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int num = scan.nextInt();
        int[] target = new int[num];

        for(int i = 0; i<num; i++){ // 찾아야 하는 targer 배열
            target[i] = scan.nextInt();
        }

        int[] intArr = new int[length]; // 1~ n 까지의 정수 받을 초기 배열
        for(int i = 0; i <length ; i++){
            intArr[i] = i+1;
        }

        int count = 0; // Shift 해주는 수 count
        int popCount = 0; // target 찾은 개수

        while(popCount < num){ // target 다 찾을때까지 while 문
            int index = findIndex(intArr, target[popCount]); // target의 index 찾기

            if(index == 0){  // 맨앞에 있으면 count 개수 더할 필요 없음

            } else if(index <= intArr.length/2){ // 연산 2가 더 유리한 경우, index수 만큼 더함
                count += index;
            } else {  //연산 3가 더 유리한 경우, length-index수 만큼 더함
                count += intArr.length - index;
            }
            int[] temp1 = Arrays.copyOfRange(intArr, 0, index);   // 새로운 배열의 뒷부분
            int[] temp2 = Arrays.copyOfRange(intArr, index+1, intArr.length);  // 새로윤 배열의 앞부분

            intArr = new int[intArr.length-1]; // 새로운 배열
            System.arraycopy(temp2, 0, intArr, 0, temp2.length); // 앞부분을 배열에 담기
            System.arraycopy(temp1, 0,intArr, temp2.length, temp1.length); // 뒷부분을 배열에 담기
            popCount++; // 다음 target으로 이동
        }
        System.out.println(count);
    }

    public static int findIndex(int[] arr, int target){  // unordered array라 이렇게 하는게 이득일 것 같았음..
        for(int i= 0; i <arr.length; i++){
            if(arr[i] == target)
                return i;
        }
        return -1;
    }
}
