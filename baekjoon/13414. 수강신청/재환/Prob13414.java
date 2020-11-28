import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Prob13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int admit = Integer.parseInt(s[0]);
        int person = Integer.parseInt(s[1]);
        Set<String> students = new LinkedHashSet<>();

        for (int i = 0; i < person; i++) {
            String newPerson = br.readLine();
            students.remove(newPerson);
            students.add(newPerson);
        }

        Iterator<String> it = students.iterator();

        for (int i = 0; i < admit; i++) {
            System.out.println(it.next());
        }
    }
}
