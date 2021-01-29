import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Prob2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int carCount = Integer.parseInt(br.readLine());
        int overTakingCount = 0;
        Map<String, Integer> enterLog = new HashMap<>();
        int[] order = new int[carCount];

        for (int enterCarOrder = 0; enterCarOrder < carCount; enterCarOrder++) {
            String enterCar = br.readLine();
            enterLog.put(enterCar, enterCarOrder);
        }

        for (int exitCarOrder = 0; exitCarOrder < carCount; exitCarOrder++) {
            String exitCar = br.readLine();
            order[exitCarOrder] = enterLog.get(exitCar);
        }
        
        for (int i = 0; i < carCount - 1; i++) {
            for (int j = i + 1; j < carCount; j++) {
                if (order[i] > order[j]) {
                    overTakingCount++;
                    break;
                }
            }
        }
        
        System.out.println(overTakingCount);
    }


}
