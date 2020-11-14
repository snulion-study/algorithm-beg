import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Prob1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wordsCount = Integer.parseInt(br.readLine());        // number of words
        Set<String> set = new HashSet<>();

        for (int i = 0; i < wordsCount; i++) {
            set.add(br.readLine());
        }

        String[] wordsList = set.toArray(new String[set.size()]);

        Arrays.sort(wordsList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return -1;
                }
            }
        });

        for (String word : wordsList) {
            System.out.println(word);
        }
    }
}
