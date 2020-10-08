import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());                                  // 테스트 횟수
        int[] printNum = new int[testNum];

        for (int i = 0; i < testNum; i++) {                                             // 테스트 시작
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int docsCount = Integer.parseInt(st1.nextToken());
            int targetIdx = Integer.parseInt(st1.nextToken());
            int targetPriority = -1;

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Queue<Integer> printQue = new LinkedList<>();
            int ele;

            for (int j = 0; j < docsCount; j++) {
                ele = Integer.parseInt(st2.nextToken());
                printQue.add(ele);
                if (j == targetIdx) {
                    targetPriority = ele;
                }
            }

            int print = 0;

            // printQue의 max priority 값이 target document의 priority 값보다 큰 경우
            // target document는 출력되지 않고 printQue를 돌 것이다.
            while (!chkPriority(printQue, targetPriority)) {

                // head 요소가 max priority 값보다 큰 경우
                // head 요소 제거 + 프린트 횟수 증가 + targetIdx 감소(-1)
                if (chkPriority(printQue, printQue.element())) {
                    printQue.remove();
                    print++;
                }
                // head 요소가 target document의 priority 값보다 작거나 같은 경우
                // rear 요소에 head 요소 추가 + targetIdx 감소(-1)
                else {
                    printQue.add(printQue.remove());
                }

                // targetIdx 감소(-1)
                // targetIdx가 음수가 되면 큐의 가장 마지막 index를 부여
                if (--targetIdx < 0) {
                    targetIdx = printQue.size() - 1;
                }
            }   // while문을 마치면 target document의 priority와 max priority 일치

            for (int j = 0; j <= targetIdx; j++) {
                if (chkPriority(printQue, printQue.element())) {
                    printQue.remove();
                    print++;
                } else {
                    printQue.add(printQue.remove());
                }
            }   // for 문 가장 마지막에 target이 print 된다.

            printNum[i] = print;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : printNum) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

/*    static int getMax(Queue<Integer> intQue) {
        Iterator<Integer> it = intQue.iterator();
        int max = 0;
        int priority;

        while (it.hasNext()) {
            priority = it.next();
            if (max < priority) {
                max = priority;
            }
        }
        return max;
    }*/

    static boolean chkPriority(Queue<Integer> intQue, int priority) {
        Iterator<Integer> it = intQue.iterator();
        boolean chk = true;

        while(it.hasNext()) {
            if (priority < it.next()) {
                chk = false;
                break;
            }
        }
        return chk;
    }
}
