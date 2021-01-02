package source.backjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Prob1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> ll = new LinkedList<>();
        ListIterator<Character> iter = ll.listIterator();

        String txt = br.readLine();

        for(int i = 0; i < txt.length(); i++)
            iter.add(txt.charAt(i));

        int cmdnum = Integer.parseInt(br.readLine());

        for(int i = 0; i < cmdnum; i++){
            String cmd = br.readLine();
            if(cmd.charAt(0) == 'L'){
                if(iter.hasPrevious())
                    iter.previous();
            }
            else if(cmd.charAt(0) == 'D'){
                if(iter.hasNext())
                    iter.next();
            }
            else if(cmd.charAt(0) == 'B'){
                if(iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            } else {
                char ch = cmd.charAt(2);
                iter.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        ListIterator<Character> print = ll.listIterator();

        while(print.hasNext()){
            sb.append(print.next());
        }

        System.out.println(sb.toString());
    }
}
