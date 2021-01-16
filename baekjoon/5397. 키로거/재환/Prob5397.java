import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Prob5397 {
    static boolean isDelete;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            LinkedList<String> curPw = new LinkedList<>();
            String input = br.readLine();
            int curIdx = 0;

            for (int j = 0; j < input.length(); j++) {
                String str = Character.toString(input.charAt(j));
                curIdx += moveCursor(str, curIdx, curPw);
                isDelete = false;
                curPw = addStr(str, curIdx, curPw);

                if (!str.equals("<") && !str.equals(">")) {
                    if (isDelete) {
                        curIdx -= 1;
                    }
                    else if (!str.equals("-")) {
                        curIdx += 1;
                    }
                }
                // sb.append("(").append(str).append(", ").append(curIdx).append(", ").append(curPw).append(") ");
            }

            for (String s : curPw) {
                sb.append(s);
            }
            if (i != testCase - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static int moveCursor(String str, int curIdx, LinkedList<String> curPw) {
        switch (str) {
            case "<":
                if (curIdx > 0) {
                    return -1;
                }
                break;
            case ">":
                if (!curPw.isEmpty() &&  curPw.size() > curIdx) {
                    return 1;
                }
                break;
        }
        return 0;
    }

    static LinkedList<String> addStr(String str, int curIdx, LinkedList<String> curPw) {
        switch (str) {
            case "<":
            case ">":
                return curPw;
            case "-":
                if (!curPw.isEmpty() && curIdx != 0) {
                    curPw.remove(curIdx - 1);
                    isDelete = true;
                }
                return curPw;
        }
        curPw.add(curIdx, str);
        return curPw;
    }
}
