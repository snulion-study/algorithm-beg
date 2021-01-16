import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Prob5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int topFloor = Integer.parseInt(stk.nextToken());
        int currFloor = Integer.parseInt(stk.nextToken());
        int officeFloor = Integer.parseInt(stk.nextToken());
        int upFloor = Integer.parseInt(stk.nextToken());
        int downFloor = Integer.parseInt(stk.nextToken());



        int interval = 0;                                               // | 현재층 - 사무실 층 |
        int[] moveFloors = new int[100000];            // 이동가능한 층 단위 집합

        if (currFloor - officeFloor < 0) {
            // ...
            // 사무실 위치
            // ...
            // 현재 위치
            // ...
            if (upFloor == 0) {
                System.out.println("use the stairs");
                return;
            }

            interval = officeFloor - currFloor;
            int moveFloor = upFloor;                                        // 이동하는 층 수
            int idx = 0;

            if (downFloor == 0) {
                moveFloors[0] = moveFloor;
            }
            else {
                while (moveFloor > 0) {
                    moveFloors[idx++] = moveFloor;
                    moveFloor -= downFloor;
                }
            }
        }
        else if (currFloor - officeFloor > 0) {
            // ...
            // 현재 위치
            // ...
            // 사무실 위치
            // ...
            if (downFloor == 0) {
                System.out.println("use the stairs");
                return;
            }

            interval = currFloor - officeFloor;
            int moveFloor = downFloor;                                        // 이동하는 층 수
            int idx = 0;
            if (upFloor == 0) {
                moveFloors[0] = moveFloor;
            }
            else {
                while (moveFloor > 0) {
                    moveFloors[idx++] = moveFloor;
                    moveFloor -= upFloor;
                }
            }
        }
        else {
            // 현재 위치 == 사무실 위치
            System.out.println(0);
            return;
        }

        int minButtonClick = minButtonClick(interval, moveFloors);
        if (minButtonClick == -1) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(minButtonClick);
    }

    static int minButtonClick(int interval, int[] moveFloors) {
        int remainInterval = interval;
        int count = 0;

        for (int i = 0; moveFloors[i] != 0; i++) {
            if (remainInterval == 0 || moveFloors[i] == 0) {
                return count;
            }
            count += (remainInterval / moveFloors[i]) * (i + 1);
            remainInterval %= moveFloors[i];
        }

        if (remainInterval != 0) {
            return -1;
        }
        return count;
    }
}
