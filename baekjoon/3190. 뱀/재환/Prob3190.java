import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] apple = new int[size][size];
        int[][] board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = 100 * i + j;
            }
        }
        int position = Integer.parseInt(br.readLine());

        for (int i = 0; i < position; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(stk.nextToken());
            int column = Integer.parseInt(stk.nextToken());
            apple[row][column] = 1;
        }

        int turn = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[turn];
        for (int i = 0; i < turn; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(stk.nextToken());
            switch (stk.nextToken()) {
                case "D":
                    pairs[i] = new Pair(time, 1);
                    break;
                case "L":
                    pairs[i] = new Pair(time, 0);
                    break;
            }
        }

        boolean gameOver = false;
        int timeCount = 0;
        int x = 0;
        int y = 0;
        Queue<Integer> snake = new LinkedList<>();

        while(!gameOver) {
            for (int i = 0; i < turn; i++) {
                for (; timeCount < pairs[i].time;) {
                    if (apple[x][y] == 0) {
                        snake.add(board[x][y]);
                        snake.remove();
                    } else {
                        snake.add(board[x][y]);
                    }
                    timeCount++;
                }
            }
        }
    }

    static class Pair {
        int time;
        int direction;

        public Pair(int time, int direction) {
            this.time = time;
            this.direction = direction;
        }
    }
}
