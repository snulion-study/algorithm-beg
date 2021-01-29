import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Prob4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> trees = new LinkedHashMap<>();
        String nameOfTree;
        double totalTreeCount = 0;

        // Input
        while ((nameOfTree = br.readLine()) != null && nameOfTree.length() != 0) {
            boolean isAlreadyRegisteredTree = trees.containsKey(nameOfTree);
            if (isAlreadyRegisteredTree) {
                int selectedTreeCount = trees.get(nameOfTree);
                trees.put(nameOfTree, selectedTreeCount + 1);
            } else {
                trees.put(nameOfTree, 1);
            }
            totalTreeCount++;
        }

        // Sort
        TreeMap<String, Integer> sortedTrees = new TreeMap<>(trees);

        // Output
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : sortedTrees.entrySet()) {
            String percentageOfTree = String.format("%.4f", entry.getValue() / totalTreeCount * 100);
            sb.append(entry.getKey()).append(" ").append(percentageOfTree).append('\n');
        }

        System.out.println(sb);
    }
}
