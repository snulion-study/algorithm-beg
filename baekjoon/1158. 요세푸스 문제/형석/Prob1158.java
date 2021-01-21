package source.backjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class Prob1158 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int k = stdIn.nextInt();
        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++)
            queue.add(i+1);

        sb.append('<');
        while(!queue.isEmpty()){
            for(int i = 0; i < k-1; i++){
                queue.addLast(queue.removeFirst());
            }
            sb.append(queue.removeFirst() + ", ");
        }
        sb.setLength(sb.length()-2);
        sb.append('>');

        System.out.println(sb.toString());

    }
}
