import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dices = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dices[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.parallelSort(dices);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int dice : dices) {
            Integer key = map.floorKey(dice);
            if (key == null) {
                map.put(1, map.getOrDefault(1, 0) + 1);
            } else {
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
                map.put(key + 1, map.getOrDefault(key + 1, 0) + 1);
            }
        }
        int sum = 0;
        for (int value : map.values()) {
            sum += value;
        }
        System.out.println(sum);
    }
}
