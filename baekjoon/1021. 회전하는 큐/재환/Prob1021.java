import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st1.nextToken());                   // 큐의 크기 : size(N)
        int count = Integer.parseInt(st1.nextToken());                  // 뽑아내려고 하는 수의 개수 : M(count)

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] idx = new int[count];

        for (int i = 0; i < count; i++) {
            idx[i] = Integer.parseInt(st2.nextToken()) - 1;
        }

        Queue<Integer> intQue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            intQue.add(i);
        }

        boolean moveLeft;
        int num = 0;

        for (int i = 0; i < count; i++) {
            while (intQue.element() != idx[i]) {
                int index = getIdx(intQue, idx[i]);
                moveLeft = (intQue.size() - index) > index;

                if (moveLeft) {
                    intQue.add(intQue.remove());
                    num++;
                } else {
                    for (int j = 0; j < intQue.size() - 1; j++) {
                        intQue.add(intQue.remove());
                    }
                    num++;
                }
            }
            intQue.remove();
        }
        System.out.println(num);
    }

    static int getIdx(Queue<Integer> intQue, int n) {
        Iterator<Integer> it = intQue.iterator();
        int idx = 0;

        while(it.hasNext()) {
            if (it.next() == n) {
                return idx;
            } else {
                idx++;
            }
        }
        return idx;
    }
}
