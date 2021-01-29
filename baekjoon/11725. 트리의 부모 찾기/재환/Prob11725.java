import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.util.StringTokenizer;

public class Prob11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        int[] parentOfNode = new int[nodeCount];
        parentOfNode[0] = -1;

        for (int i = 1; i < nodeCount; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int firstNodeKey = Integer.parseInt(stk.nextToken());
            int secondNodeKey = Integer.parseInt(stk.nextToken());
            int parentNodeKey;
            int childNodeKey;

            if (parentOfNode[firstNodeKey - 1] != 0) {
                parentNodeKey = firstNodeKey;
                childNodeKey = secondNodeKey;
            } else {
                parentNodeKey = secondNodeKey;
                childNodeKey = firstNodeKey;
            }

            parentOfNode[childNodeKey - 1] = parentNodeKey;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < nodeCount; i++) {
            if (i == nodeCount - 1) {
                sb.append(parentOfNode[i]);
                break;
            }
            sb.append(parentOfNode[i]).append('\n');
        }
        System.out.println(sb);
    }
}
