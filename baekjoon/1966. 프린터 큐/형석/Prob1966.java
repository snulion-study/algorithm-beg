package source.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prob1966 {
    public static void main(String[] args) throws IOException {
//        원래 시도했던 야매 풀이 방식. Target의 index를 기준으로 Array에서 그 Target보다 큰 중요도를 가진 요소의 수를 세고,
//        그 값들 중 가장 마지막 Index를 가진 것보다 뒤에있는 Target과 같은 중요도를 가진 요소 개수 +
//        앞에서부터 센 Target과 같은 중요도를 가진 수 세서 출력.
//        TestCase는 통과하는데, Fail.

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num = Integer.parseInt(br.readLine());
//
//        for(int i= 0; i <num; i++){
//            String[] temp1 = br.readLine().split(" ");
//            int length = Integer.parseInt(temp1[0]);
//            int target = Integer.parseInt(temp1[1]);
//            int count = 0;
//            int lastIndex = 0;
//            String[] temp2 = br.readLine().split(" ");
//
//            int[] array = new int[length];
//
//
//            for(int j = 0; j<temp2.length; j++){
//                array[j] = Integer.parseInt(temp2[j]);
//            }
//
//
//            for(int j = 0; j<length; j++){
//                if(array[j] > array[target]){
//                    count++;
//                    lastIndex = j;
//                }
//            }
//
//            if(lastIndex > target){
//                for(int j = lastIndex+1; j<array.length; j++){
//                    if(array[j] == array[target])
//                        count++;
//                }
//                for(int j = 0; j <= target; j++){
//                    if(array[j] == array[target]) {
//                        count++;
//                    }
//                }
//            } else{
//                for(int j = lastIndex; j<=target; j++){
//                    if(array[j] == array[target])
//                        count++;
//                }
//            }
//
//
//            System.out.println(count);
//        }

        Scanner stdIn = new Scanner(System.in);
        int num = stdIn.nextInt();
        for(int i= 0; i<num; i++){
            int length = stdIn.nextInt(); // 각 횟수당 받을 배열의 길이
            int index = stdIn.nextInt(); // Target의 Index
            int count = 0; // 프린트 하는 수
            Queue que = new Queue();

            for(int j = 0; j < length; j++){
                que.enqueue(new Items(j, stdIn.nextInt())); // 초기 index와, 중요도를 Items에 담고, 그걸 que에 enqueue
            }

            while(true){
                if(que.isMax()){ // max이면서 내가 원하는 Target이 아닌경우 단순히 dequeue & Count세기
                    if(que.dequeue().key == index) // 원하는 Target일 경우 break;
                        break;
                    count++;
                } else{
                    que.enqueue(que.dequeue()); // 맨 앞에서 맨 뒤로 요소를 보냄.
                }

            }
            System.out.println(count + 1); // 순서 출력
        }


    }

    public static class Queue{
        private ArrayList<Items> arrayQueue = new ArrayList<Items>(); // Queue를 담을 Array형 List

        public void enqueue(Items item){ // 새로운 요소를 추가
            arrayQueue.add(item);
        }

        public Items dequeue(){ // 맨 앞 요소를 제거
            if(arrayQueue.isEmpty()){
                return null;
            }
            return arrayQueue.remove(0);
        }

        public int peek(){ //맨 앞 요소의 값을 보기 위함.
            if(arrayQueue.isEmpty()){
                return 0;
            }
            return arrayQueue.get(0).elem;

        }

        public boolean isMax(){ //맨 앞에 있는 요소가, Queue에서 가장 큰 중요도를 가지는지 확인
            if(arrayQueue.isEmpty()){
                return true;
            }
            int max = arrayQueue.get(0).elem;
            for(int i= 0; i<arrayQueue.size(); i++){
                if(max < arrayQueue.get(i).elem)
                    return false;
            }
            return true;
        }


    }

    public static class Items{  // enqueue, dequeue를 할 때, 초기 index를 보존 할 방법을 찾기 위해 만든 Items
        private int key;  //초기 Index를 담아 둔 값
        private int elem; //각 요소의 중요도를 담은 값

        Items(int keyval, int eval){
            key = keyval;
            elem = eval;
        }
    }
}
