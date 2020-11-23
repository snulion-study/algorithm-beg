import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Prob14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = br.readLine().split(" ");
        int mainElements = Integer.parseInt(elements[0]);
        int chkElements = Integer.parseInt(elements[1]);
        Set<String> mainSet = new HashSet<>();
//        Set<String> chkSet = new HashSet<>();
        for (int i = 0; i < mainElements; i++) {
            mainSet.add(br.readLine());
        }


        /*for (int i = 0; i < chkElements; i++) {
            chkSet.add(br.readLine());
        }*/

        int matchCount = 0;
//        Iterator<String> it = chkSet.iterator();

        /*while (it.hasNext()) {
            String s = it.next();
            if(mainSet.contains(s)) {
                matchCount++;
                System.out.println(s + " : " + matchCount);
            }
        }*/
        for (int i = 0; i < chkElements; i++) {
            if (mainSet.contains(br.readLine())) {
                matchCount++;
            }
        }
        System.out.println(matchCount);
    }
}
